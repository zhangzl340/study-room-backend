package com.studyroom.modules.auth.service.impl;

import com.studyroom.common.constant.RedisKeyConstant;
import com.studyroom.common.exception.BusinessException;
import com.studyroom.common.exception.ErrorCode;
import com.studyroom.common.utils.JwtUtils;
import com.studyroom.common.utils.Md5Utils;
import com.studyroom.common.utils.RedisUtils;
import com.studyroom.modules.auth.dto.request.ChangePasswordRequest;
import com.studyroom.modules.auth.dto.request.LoginRequest;
import com.studyroom.modules.auth.dto.request.RefreshTokenRequest;
import com.studyroom.modules.auth.dto.request.RegisterRequest;
import com.studyroom.modules.auth.dto.request.VerifyIdentityRequest;
import com.studyroom.modules.auth.dto.response.LoginResponse;
import com.studyroom.modules.auth.dto.response.RefreshTokenResponse;
import com.studyroom.modules.auth.dto.response.VerifyIdentityResponse;
import com.studyroom.modules.auth.service.AuthService;
import com.studyroom.modules.user.entity.User;
import com.studyroom.modules.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final JwtUtils jwtUtils;
    private final RedisUtils redisUtils;

    @Value("${study-room.jwt.expiration}")
    private Long expiration;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LoginResponse login(LoginRequest request, String ip) {
        User user = userService.getUserByUsername(request.getUsername());
        if (user == null) {
            throw new BusinessException(ErrorCode.LOGIN_FAILED);
        }

        String encryptedPassword = Md5Utils.MD5Encode(request.getPassword());
        if (!encryptedPassword.equals(user.getPassword())) {
            throw new BusinessException(ErrorCode.LOGIN_FAILED);
        }

        if (user.getStatus() != 1) {
            throw new BusinessException(ErrorCode.ACCOUNT_DISABLED);
        }

        // 清理用户的旧token，确保同一时间只有一个有效的token
        String userTokenKey = RedisKeyConstant.USER_TOKEN_KEY + "user:" + user.getId();
        Object oldTokenKey = redisUtils.get(userTokenKey);
        if (oldTokenKey != null) {
            redisUtils.delete(oldTokenKey.toString());
            log.debug("清理用户旧token: {}", user.getUsername());
        }

        // 生成新token
        String accessToken = jwtUtils.generateAccessToken(user.getId(), user.getUsername(), user.getRoleType());
        String refreshToken = jwtUtils.generateRefreshToken(user.getId());

        // 将access token存储到Redis，设置与token相同的过期时间
        // 同时存储用户ID映射，便于后续管理
        String tokenKey = RedisKeyConstant.USER_TOKEN_KEY + accessToken;
        redisUtils.set(tokenKey, user.getId(), expiration / 1000);
        
        // 存储用户的当前token，用于后续清理
        redisUtils.set(userTokenKey, tokenKey, expiration / 1000);

        userService.updateLastLogin(user.getId(), ip);

        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .tokenType("Bearer")
                .expiresIn(expiration / 1000)
                .userId(user.getId())
                .username(user.getUsername())
                .role(user.getRoleType())
                .realName(user.getRealName())
                .avatar(user.getAvatar())
                .build();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(RegisterRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new BusinessException(ErrorCode.BAD_REQUEST, "两次密码输入不一致");
        }

        if (userService.existsByUsername(request.getUsername())) {
            throw new BusinessException(ErrorCode.USERNAME_ALREADY_EXISTS);
        }

        if (request.getStudentId() != null && userService.existsByStudentId(request.getStudentId())) {
            throw new BusinessException(ErrorCode.STUDENT_ID_ALREADY_EXISTS);
        }

        if (request.getEmail() != null && userService.existsByEmail(request.getEmail())) {
            throw new BusinessException(ErrorCode.EMAIL_ALREADY_EXISTS);
        }

        if (request.getPhone() != null && userService.existsByPhone(request.getPhone())) {
            throw new BusinessException(ErrorCode.PHONE_ALREADY_EXISTS);
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(Md5Utils.MD5Encode(request.getPassword()));
        user.setRealName(request.getRealName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setStudentId(request.getStudentId());
        user.setCollege(request.getCollege());
        user.setMajor(request.getMajor());
        user.setGrade(request.getGrade());
        user.setClassName(request.getClassName());
        user.setRoleType("STUDENT");
        user.setStatus(1);
        user.setIdentityStatus(0);
        user.setCreditScore(100);
        user.setTotalReservations(0);
        user.setCompletedReservations(0);
        user.setViolationCount(0);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());

        userService.save(user);
    }

    @Override
    public RefreshTokenResponse refreshToken(RefreshTokenRequest request) {
        if (!jwtUtils.validateToken(request.getRefreshToken())) {
            throw new BusinessException(ErrorCode.TOKEN_INVALID);
        }

        if (!"refresh".equals(jwtUtils.getTokenType(request.getRefreshToken()))) {
            throw new BusinessException(ErrorCode.TOKEN_INVALID);
        }

        Long userId = jwtUtils.getUserId(request.getRefreshToken());
        User user = userService.getById(userId);
        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }

        String newAccessToken = jwtUtils.generateAccessToken(user.getId(), user.getUsername(), user.getRoleType());

        return RefreshTokenResponse.builder()
                .accessToken(newAccessToken)
                .tokenType("Bearer")
                .expiresIn(expiration / 1000)
                .build();
    }

    @Override
    public void logout(String token) {
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        
        if (token != null && !token.isEmpty()) {
            boolean tokenIsExist = redisUtils.hasKey(token);

            // 从Redis中删除token，使其失效
            boolean deleted = redisUtils.delete(RedisKeyConstant.USER_TOKEN_KEY + token);
            if (deleted) {
                log.info("用户登出成功，Token已失效: {}", token.substring(0, 20) + "...");
            } else {
                log.warn("Token不存在或已失效: {}", token.substring(0, 20) + "...");
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void changePassword(Long userId, ChangePasswordRequest request) {
        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            throw new BusinessException(ErrorCode.BAD_REQUEST, "两次密码输入不一致");
        }

        if (request.getOldPassword().equals(request.getNewPassword())) {
            throw new BusinessException(ErrorCode.PASSWORD_SAME);
        }

        userService.changePassword(userId, request.getOldPassword(), request.getNewPassword());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public VerifyIdentityResponse verifyIdentity(Long userId, VerifyIdentityRequest request) {
        User user = userService.getById(userId);
        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }

        if (user.getIdentityStatus() == 1) {
            return VerifyIdentityResponse.builder()
                    .verified(true)
                    .message("您已完成实名认证")
                    .realName(user.getRealName())
                    .idCard(maskIdCard(user.getIdentityCard()))
                    .build();
        }

        if (!request.getStudentId().equals(user.getStudentId())) {
            throw new BusinessException(ErrorCode.BAD_REQUEST, "学号与账号不匹配");
        }

        user.setRealName(request.getRealName());
        user.setIdentityCard(request.getIdCard());
        user.setIdentityStatus(1);
        user.setUpdateTime(LocalDateTime.now());
        userService.updateById(user);

        return VerifyIdentityResponse.builder()
                .verified(true)
                .message("实名认证成功")
                .realName(request.getRealName())
                .idCard(maskIdCard(request.getIdCard()))
                .build();
    }

    private String maskIdCard(String idCard) {
        if (idCard == null || idCard.length() < 18) {
            return idCard;
        }
        return idCard.substring(0, 6) + "********" + idCard.substring(14);
    }
}
