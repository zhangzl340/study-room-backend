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
import com.studyroom.modules.auth.dto.request.UpdateProfileRequest;
import com.studyroom.modules.auth.dto.response.LoginResponse;
import com.studyroom.modules.auth.dto.response.RefreshTokenResponse;
import com.studyroom.modules.auth.dto.response.VerifyIdentityResponse;
import com.studyroom.modules.auth.dto.response.UserInfoResponse;
import com.studyroom.modules.auth.service.AuthService;
import com.studyroom.modules.user.entity.User;
import com.studyroom.modules.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Map;
import java.util.HashMap;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
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

    @Override
    public UserInfoResponse getCurrentUser(Long userId) {
        User user = userService.getById(userId);
        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }

        return UserInfoResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .realName(user.getRealName())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .phone(user.getPhone())
                .avatar(user.getAvatar())
                .studentId(user.getStudentId())
                .college(user.getCollege())
                .major(user.getMajor())
                .grade(user.getGrade())
                .className(user.getClassName())
                .creditScore(user.getCreditScore())
                .roleType(user.getRoleType())
                .status(user.getStatus())
                .lastLoginTime(user.getLastLoginTime())
                .createTime(user.getCreateTime())
                .build();
    }

    @Override
    public UserInfoResponse updateUserInfo(Long userId, UpdateProfileRequest request) {
        User user = userService.getById(userId);
        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }

        if (request.getEmail() != null && !request.getEmail().equals(user.getEmail())) {
            if (userService.existsByEmail(request.getEmail())) {
                throw new BusinessException(ErrorCode.EMAIL_ALREADY_EXISTS);
            }
            user.setEmail(request.getEmail());
        }

        if (request.getPhone() != null && !request.getPhone().equals(user.getPhone())) {
            if (userService.existsByPhone(request.getPhone())) {
                throw new BusinessException(ErrorCode.PHONE_ALREADY_EXISTS);
            }
            user.setPhone(request.getPhone());
        }

        if (request.getNickname() != null) {
            user.setNickname(request.getNickname());
        }

        if (request.getAvatar() != null) {
            user.setAvatar(request.getAvatar());
        }

        if (request.getCollege() != null) {
            user.setCollege(request.getCollege());
        }

        if (request.getMajor() != null) {
            user.setMajor(request.getMajor());
        }

        if (request.getGrade() != null) {
            user.setGrade(request.getGrade());
        }

        if (request.getClassName() != null) {
            user.setClassName(request.getClassName());
        }

        user.setUpdateTime(LocalDateTime.now());
        userService.updateById(user);

        return getCurrentUser(userId);
    }

    @Override
    public Map<String, Object> getCaptcha() {
        try {
            LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(150, 50, 6, 20);
            // 生成6位随机验证码
            String captchaCode = lineCaptcha.getCode();
            
            // 生成验证码key
            String captchaKey = "captcha:" + java.util.UUID.randomUUID().toString();
            
            // 将验证码存储到Redis，设置5分钟过期
            redisUtils.set(RedisKeyConstant.CAPTCHA_KEY + captchaKey, captchaCode , 300);

            // 将验证码图片转换为base64
            String base64Image;
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                lineCaptcha.write(outputStream); // 写入图片流
                byte[] imageBytes = outputStream.toByteArray();
                // 拼接Base64前缀，前端可直接作为img的src属性
                base64Image = "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);
            } // 自动关闭outputStream
            
            Map<String, Object> result = new HashMap<>();
            result.put("captchaKey", captchaKey);
            result.put("captchaImage", base64Image);
            
            log.info("生成验证码: {}，key: {}", captchaCode, captchaKey);
            return result;
        } catch (Exception e) {
            log.error("生成验证码失败", e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "生成验证码失败");
        }
    }

    @Override
    public void requestResetPassword(String email) {
        try {
            // 验证邮箱是否存在
            User user = userService.getUserByEmail(email);
            if (user == null) {
                throw new BusinessException(ErrorCode.USER_NOT_FOUND, "该邮箱未注册");
            }
            
            // 生成重置密码token
            String resetToken = java.util.UUID.randomUUID().toString();
            
            // 将token存储到Redis，设置30分钟过期
            String tokenKey = RedisKeyConstant.RESET_PASSWORD_KEY + resetToken;
            redisUtils.set(tokenKey, user.getId().toString(), 1800);
            
            // 构建重置密码链接
            String resetUrl = "http://localhost:3000/reset-password?token=" + resetToken;
            
            // 这里应该发送真实的重置密码邮件
            // 暂时只记录日志
            log.info("发送重置密码邮件到: {}", email);
            log.info("重置密码链接: {}", resetUrl);
            log.info("重置密码token: {}", resetToken);
            
            // TODO: 集成邮件发送服务，发送包含重置密码链接的邮件
            // emailService.sendResetPasswordEmail(user.getEmail(), user.getRealName(), resetUrl);
            
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            log.error("请求重置密码失败", e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "请求重置密码失败");
        }
    }

    @Override
    public void resetPassword(String token, String newPassword) {
        try {
            // 验证token有效性
            String tokenKey = RedisKeyConstant.RESET_PASSWORD_KEY + token;
            Object userIdObj = redisUtils.get(tokenKey);
            
            if (userIdObj == null) {
                throw new BusinessException(ErrorCode.TOKEN_INVALID, "重置密码链接已过期或无效");
            }
            
            Long userId = Long.valueOf(userIdObj.toString());
            
            // 验证用户是否存在
            User user = userService.getById(userId);
            if (user == null) {
                throw new BusinessException(ErrorCode.USER_NOT_FOUND);
            }
            
            // 验证新密码复杂度
            if (newPassword.length() < 6 || newPassword.length() > 20) {
                throw new BusinessException(ErrorCode.BAD_REQUEST, "密码长度必须在6-20之间");
            }
            
            // 加密新密码
            String encryptedPassword = Md5Utils.MD5Encode(newPassword);
            
            // 更新用户密码
            user.setPassword(encryptedPassword);
            user.setUpdateTime(LocalDateTime.now());
            userService.updateById(user);
            
            // 删除Redis中的token
            redisUtils.delete(tokenKey);
            
            // 清理用户的旧token，确保用户需要重新登录
            String userTokenKey = RedisKeyConstant.USER_TOKEN_KEY + "user:" + user.getId();
            Object oldTokenKey = redisUtils.get(userTokenKey);
            if (oldTokenKey != null) {
                redisUtils.delete(oldTokenKey.toString());
                redisUtils.delete(userTokenKey);
                log.info("清理用户旧token: {}", user.getUsername());
            }
            
            log.info("用户重置密码成功: {}", user.getUsername());
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            log.error("重置密码失败", e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "重置密码失败");
        }
    }
}
