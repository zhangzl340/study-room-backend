package com.studyroom.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.studyroom.modules.user.dto.request.UpdateProfileRequest;
import com.studyroom.modules.user.dto.request.UserQueryRequest;
import com.studyroom.modules.user.dto.response.UserInfoResponse;
import com.studyroom.modules.user.dto.response.UserListResponse;
import com.studyroom.modules.user.entity.User;

public interface UserService extends IService<User> {

    User getUserByUsername(String username);

    User getUserByStudentId(String studentId);

    User getUserByEmail(String email);

    User getUserByPhone(String phone);

    boolean existsByUsername(String username);

    boolean existsByStudentId(String studentId);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    UserInfoResponse getUserInfo(Long userId);

    boolean updateProfile(Long userId, UpdateProfileRequest request);

    boolean changePassword(Long userId, String oldPassword, String newPassword);

    boolean updateLastLogin(Long userId, String ip);

    UserListResponse.PageData getUserList(UserQueryRequest request);
}
