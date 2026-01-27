package com.studyroom.modules.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.studyroom.modules.user.dto.request.UpdateProfileRequest;
import com.studyroom.modules.user.dto.request.UserCreateRequest;
import com.studyroom.modules.user.dto.request.UserQueryRequest;
import com.studyroom.modules.user.dto.request.UserUpdateRequest;
import com.studyroom.modules.user.dto.response.UserInfoResponse;
import com.studyroom.modules.user.dto.response.UserListResponse;
import com.studyroom.modules.user.entity.User;
import com.studyroom.modules.user.vo.UserVO;

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

    UserVO getUserDetail(Long id);

    UserVO createUser(UserCreateRequest request);

    UserVO updateUser(Long id, UserUpdateRequest request);

    void deleteUser(Long id);

    UserVO updateUserStatus(Long id, String status);

    String resetUserPassword(Long id);

    UserVO adjustUserCredit(Long id, Integer amount, String reason);
}
