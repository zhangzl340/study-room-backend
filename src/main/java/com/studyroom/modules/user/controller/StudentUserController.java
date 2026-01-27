package com.studyroom.modules.user.controller;

import com.studyroom.common.result.Result;
import com.studyroom.modules.user.dto.request.UpdateProfileRequest;
import com.studyroom.modules.user.dto.response.UserInfoResponse;
import com.studyroom.modules.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "用户接口", description = "学生端用户信息管理")
public class StudentUserController {

    private final UserService userService;

    @GetMapping("/profile")
    @Operation(summary = "获取个人信息")
    public Result<UserInfoResponse> getProfile(Authentication authentication) {
        Long userId = (Long) authentication.getPrincipal();
        UserInfoResponse userInfo = userService.getUserInfo(userId);
        return Result.success(userInfo);
    }

    @PutMapping("/profile")
    @Operation(summary = "更新个人信息")
    public Result<Void> updateProfile(@Valid @RequestBody UpdateProfileRequest request, Authentication authentication) {
        Long userId = (Long) authentication.getPrincipal();
        userService.updateProfile(userId, request);
        return Result.success("更新成功");
    }
}
