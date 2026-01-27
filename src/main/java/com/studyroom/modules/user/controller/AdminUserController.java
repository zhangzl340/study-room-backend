package com.studyroom.modules.user.controller;

import com.studyroom.common.result.Result;
import com.studyroom.modules.user.dto.request.UserQueryRequest;
import com.studyroom.modules.user.dto.request.UserCreateRequest;
import com.studyroom.modules.user.dto.request.UserUpdateRequest;
import com.studyroom.modules.user.dto.response.UserListResponse;
import com.studyroom.modules.user.service.UserService;
import com.studyroom.modules.user.vo.UserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/user")
@RequiredArgsConstructor
@Tag(name = "管理端用户接口", description = "用户管理相关接口")
public class AdminUserController {

    private final UserService userService;

    @GetMapping("/list")
    @Operation(summary = "获取用户列表（分页）")
    public Result<UserListResponse.PageData> getUserList(@Valid UserQueryRequest request) {
        UserListResponse.PageData pageData = userService.getUserList(request);
        return Result.success(pageData);
    }

    @GetMapping("/detail/{id}")
    @Operation(summary = "获取用户详情")
    public Result<UserVO> getUserDetail(@PathVariable Long id) {
        return Result.success(userService.getUserDetail(id));
    }

    @PostMapping("/create")
    @Operation(summary = "创建用户")
    public Result<UserVO> createUser(@Valid @RequestBody UserCreateRequest request) {
        return Result.success(userService.createUser(request));
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "更新用户")
    public Result<UserVO> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequest request) {
        return Result.success(userService.updateUser(id, request));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除用户")
    public Result<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return Result.success("删除用户成功");
    }

    @PutMapping("/status/{id}")
    @Operation(summary = "启用/禁用用户")
    public Result<UserVO> updateUserStatus(@PathVariable Long id, @RequestParam String status) {
        return Result.success(userService.updateUserStatus(id, status));
    }

    @PostMapping("/reset-password/{id}")
    @Operation(summary = "重置用户密码")
    public Result<String> resetUserPassword(@PathVariable Long id) {
        return Result.success(userService.resetUserPassword(id));
    }

    @PostMapping("/adjust-credit/{id}")
    @Operation(summary = "调整用户信用分")
    public Result<UserVO> adjustUserCredit(@PathVariable Long id, @RequestParam Integer amount, @RequestParam String reason) {
        return Result.success(userService.adjustUserCredit(id, amount, reason));
    }
}
