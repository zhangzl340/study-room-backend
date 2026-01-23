package com.studyroom.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.studyroom.common.exception.BusinessException;
import com.studyroom.common.exception.ErrorCode;
import com.studyroom.common.utils.Md5Utils;
import com.studyroom.modules.user.dto.request.UpdateProfileRequest;
import com.studyroom.modules.user.dto.request.UserQueryRequest;
import com.studyroom.modules.user.dto.response.UserInfoResponse;
import com.studyroom.modules.user.dto.response.UserListResponse;
import com.studyroom.modules.user.entity.User;
import com.studyroom.modules.user.mapper.UserMapper;
import com.studyroom.modules.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public User getUserByStudentId(String studentId) {
        return userMapper.selectByStudentId(studentId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    @Override
    public User getUserByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }

    @Override
    public boolean existsByUsername(String username) {
        return getUserByUsername(username) != null;
    }

    @Override
    public boolean existsByStudentId(String studentId) {
        if (studentId == null || studentId.isEmpty()) {
            return false;
        }
        return getUserByStudentId(studentId) != null;
    }

    @Override
    public boolean existsByEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return getUserByEmail(email) != null;
    }

    @Override
    public boolean existsByPhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            return false;
        }
        return getUserByPhone(phone) != null;
    }

    @Override
    public UserInfoResponse getUserInfo(Long userId) {
        User user = getById(userId);
        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }
        return convertToUserInfoResponse(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateProfile(Long userId, UpdateProfileRequest request) {
        User user = getById(userId);
        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }

        if (request.getEmail() != null && !request.getEmail().equals(user.getEmail())) {
            if (existsByEmail(request.getEmail())) {
                throw new BusinessException(ErrorCode.EMAIL_ALREADY_EXISTS);
            }
            user.setEmail(request.getEmail());
        }

        if (request.getPhone() != null && !request.getPhone().equals(user.getPhone())) {
            if (existsByPhone(request.getPhone())) {
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
        return updateById(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changePassword(Long userId, String oldPassword, String newPassword) {
        User user = getById(userId);
        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }

        String encryptedOldPassword = Md5Utils.MD5Encode(oldPassword);
        if (!encryptedOldPassword.equals(user.getPassword())) {
            throw new BusinessException(ErrorCode.PASSWORD_ERROR);
        }

        String encryptedNewPassword = Md5Utils.MD5Encode(newPassword);
        user.setPassword(encryptedNewPassword);
        user.setUpdateTime(LocalDateTime.now());

        return updateById(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateLastLogin(Long userId, String ip) {
        User user = getById(userId);
        if (user == null) {
            return false;
        }

        user.setLastLoginTime(LocalDateTime.now());
        user.setLastLoginIp(ip);
        user.setUpdateTime(LocalDateTime.now());

        return updateById(user);
    }

    private UserInfoResponse convertToUserInfoResponse(User user) {
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
    public UserListResponse.PageData getUserList(UserQueryRequest request) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

        if (StringUtils.isNotBlank(request.getUsername())) {
            queryWrapper.like(User::getUsername, request.getUsername());
        }

        if (StringUtils.isNotBlank(request.getRealName())) {
            queryWrapper.like(User::getRealName, request.getRealName());
        }

        if (StringUtils.isNotBlank(request.getStudentId())) {
            queryWrapper.eq(User::getStudentId, request.getStudentId());
        }

        if (StringUtils.isNotBlank(request.getCollege())) {
            queryWrapper.eq(User::getCollege, request.getCollege());
        }

        if (StringUtils.isNotBlank(request.getMajor())) {
            queryWrapper.eq(User::getMajor, request.getMajor());
        }

        if (StringUtils.isNotBlank(request.getGrade())) {
            queryWrapper.eq(User::getGrade, request.getGrade());
        }

        if (request.getStatus() != null) {
            queryWrapper.eq(User::getStatus, request.getStatus());
        }

        if (StringUtils.isNotBlank(request.getRoleType())) {
            queryWrapper.eq(User::getRoleType, request.getRoleType());
        }

        if (request.getIdentityStatus() != null) {
            queryWrapper.eq(User::getIdentityStatus, request.getIdentityStatus());
        }

        if (StringUtils.isNotBlank(request.getKeyword())) {
            queryWrapper.and(wrapper -> wrapper
                    .like(User::getUsername, request.getKeyword())
                    .or()
                    .like(User::getRealName, request.getKeyword())
                    .or()
                    .like(User::getStudentId, request.getKeyword())
                    .or()
                    .like(User::getPhone, request.getKeyword())
            );
        }

        queryWrapper.orderByDesc(User::getCreateTime);

        Page<User> page = new Page<>(request.getPageNum(), request.getPageSize());
        Page<User> userPage = page(page, queryWrapper);

        List<UserListResponse> records = userPage.getRecords().stream()
                .map(this::convertToUserListResponse)
                .collect(Collectors.toList());

        return UserListResponse.PageData.builder()
                .records(records)
                .total(userPage.getTotal())
                .pageNum(userPage.getCurrent())
                .pageSize(userPage.getSize())
                .pages(userPage.getPages())
                .build();
    }

    private UserListResponse convertToUserListResponse(User user) {
        return UserListResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .realName(user.getRealName())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .phone(user.getPhone())
                .avatar(user.getAvatar())
                .gender(user.getGender())
                .studentId(user.getStudentId())
                .college(user.getCollege())
                .major(user.getMajor())
                .grade(user.getGrade())
                .className(user.getClassName())
                .identityStatus(user.getIdentityStatus())
                .creditScore(user.getCreditScore())
                .totalReservations(user.getTotalReservations())
                .completedReservations(user.getCompletedReservations())
                .violationCount(user.getViolationCount())
                .roleType(user.getRoleType())
                .status(user.getStatus())
                .lastLoginTime(user.getLastLoginTime())
                .lastLoginIp(user.getLastLoginIp())
                .createTime(user.getCreateTime())
                .build();
    }
}
