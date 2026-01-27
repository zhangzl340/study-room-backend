package com.studyroom.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.studyroom.common.exception.BusinessException;
import com.studyroom.common.exception.ErrorCode;
import com.studyroom.common.utils.Md5Utils;
import com.studyroom.modules.user.dto.request.*;
import com.studyroom.modules.user.entity.User;
import com.studyroom.modules.user.mapper.UserMapper;
import com.studyroom.modules.user.service.AdminService;
import com.studyroom.modules.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceImpl extends ServiceImpl<UserMapper, User> implements AdminService {

    private final UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User createAdmin(UserCreateRequest request) {
        // 检查用户名是否已存在
        User existingUser = userMapper.selectByUsername(request.getUsername());
        if (existingUser != null) {
            throw new BusinessException(ErrorCode.USERNAME_ALREADY_EXISTS);
        }

        // 检查邮箱是否已存在
        if (StringUtils.isNotBlank(request.getEmail())) {
            User existingEmailUser = userMapper.selectByEmail(request.getEmail());
            if (existingEmailUser != null) {
                throw new BusinessException(ErrorCode.EMAIL_ALREADY_EXISTS);
            }
        }

        // 检查手机号是否已存在
        if (StringUtils.isNotBlank(request.getPhone())) {
            User existingPhoneUser = userMapper.selectByPhone(request.getPhone());
            if (existingPhoneUser != null) {
                throw new BusinessException(ErrorCode.PHONE_ALREADY_EXISTS);
            }
        }

        // 创建用户记录
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(Md5Utils.MD5Encode(request.getPassword()));
        user.setRealName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setRoleType("ADMIN");
        user.setStatus(1);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());

        if (userMapper.insert(user) <= 0) {
            throw new BusinessException(ErrorCode.ADMIN_INSERT_ERROR);
        }

        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User updateAdmin(Long id, UserUpdateRequest request) {

        // 获取用户信息
        User user = userMapper.selectById(id);
        if (user == null || "admin".equals(user.getRoleType())) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }

        // 更新用户信息
        if (StringUtils.isNotBlank(request.getName())) {
            user.setRealName(request.getName());
        }
        if (StringUtils.isNotBlank(request.getEmail())) {
            if (!request.getEmail().equals(user.getEmail())) {
                User existingEmailUser = userMapper.selectByEmail(request.getEmail());
                if (existingEmailUser != null) {
                    throw new BusinessException(ErrorCode.EMAIL_ALREADY_EXISTS);
                }
                user.setEmail(request.getEmail());
            }
        }
        if (StringUtils.isNotBlank(request.getPhone())) {
            if (!request.getPhone().equals(user.getPhone())) {
                User existingPhoneUser = userMapper.selectByPhone(request.getPhone());
                if (existingPhoneUser != null) {
                    throw new BusinessException(ErrorCode.PHONE_ALREADY_EXISTS);
                }
                user.setPhone(request.getPhone());
            }
        }

        user.setUpdateTime(LocalDateTime.now());
        if (userMapper.updateById(user) <= 0) {
            throw new BusinessException(ErrorCode.ADMIN_UPDATE_ERROR);
        }

        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteAdmin(Long id) {
        // 删除用户记录
        if (userMapper.deleteById(id) <= 0) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }
        // 删除管理员记录
        return removeById(id);
    }

    @Override
    public UserVO getAdminDetail(Long id) {

        User user = userMapper.selectById(id);
        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }

        return convertToUserVO(user);
    }

    @Override
    public List<UserVO> getAdminList(UserQueryRequest request) {


        LambdaQueryWrapper<User> userQueryWrapper = new LambdaQueryWrapper<>();
        userQueryWrapper.ne(User::getRoleType, "STUDENT");

        if (StringUtils.isNotBlank(request.getUsername())) {
            userQueryWrapper.like(User::getUsername, request.getUsername());
        }
        if (StringUtils.isNotBlank(request.getRealName())) {
            userQueryWrapper.like(User::getRealName, request.getRealName());
        }
        if (StringUtils.isNotBlank(request.getEmail())) {
            userQueryWrapper.like(User::getEmail, request.getEmail());
        }
        if (StringUtils.isNotBlank(request.getPhone())) {
            userQueryWrapper.like(User::getPhone, request.getPhone());
        }
        if (request.getStatus() != null) {
            userQueryWrapper.eq(User::getStatus, request.getStatus());
        }

        userQueryWrapper.orderByDesc(User::getCreateTime);

        List<User> users = userMapper.selectList(userQueryWrapper);
        return users.stream()
                .map(this::convertToUserVO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchImportAdmins(BatchImportRequest request) {
        if (request.getUsers() == null || request.getUsers().isEmpty()) {
            throw new BusinessException(ErrorCode.ADMIN_INSERT_ERROR);
        }

        for (UserCreateRequest userRequest : request.getUsers()) {
            createAdmin(userRequest);
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateAdminStatus(Long id, Integer status) {

        User user = userMapper.selectById(id);
        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }

        user.setStatus(status);
        user.setUpdateTime(LocalDateTime.now());

        return userMapper.updateById(user) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean resetAdminPassword(Long id, String newPassword) {
        User user = userMapper.selectById(id);
        if (user == null) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUND);
        }

        user.setPassword(Md5Utils.MD5Encode(newPassword));
        user.setUpdateTime(LocalDateTime.now());

        return userMapper.updateById(user) > 0;
    }

    private UserVO convertToUserVO(User user) {
        return UserVO.builder()
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
                .roleType(user.getRoleType())
                .status(user.getStatus())
                .lastLoginTime(user.getLastLoginTime())
                .lastLoginIp(user.getLastLoginIp())
                .createTime(user.getCreateTime())
                .build();
    }
}
