package com.studyroom.modules.user.controller;

import com.studyroom.common.result.Result;
import com.studyroom.modules.user.dto.request.UserQueryRequest;
import com.studyroom.modules.user.dto.response.UserListResponse;
import com.studyroom.modules.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/user")
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
}
