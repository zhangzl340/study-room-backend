package com.studyroom.modules.user.controller;

import com.studyroom.common.result.Result;
import com.studyroom.modules.user.dto.request.*;
import com.studyroom.modules.user.service.AdminService;
import com.studyroom.modules.user.vo.UserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/admin")
@RequiredArgsConstructor
@Tag(name = "管理员账户管理接口", description = "管理员账户的创建、更新、删除等操作")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/create")
    @Operation(summary = "创建管理员账户")
    public Result<?> createAdmin(@RequestBody UserCreateRequest request) {
        adminService.createAdmin(request);
        return Result.success("创建管理员账户成功");
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "更新管理员信息")
    public Result<?> updateAdmin(@PathVariable Long id, @RequestBody UserUpdateRequest request) {
        adminService.updateAdmin(id, request);
        return Result.success("更新管理员信息成功");
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除管理员账户")
    public Result<?> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return Result.success("删除管理员账户成功");
    }

    @GetMapping("/detail/{id}")
    @Operation(summary = "获取管理员详情")
    public Result<UserVO> getAdminDetail(@PathVariable Long id) {
        return Result.success(adminService.getAdminDetail(id));
    }

    @GetMapping("/list")
    @Operation(summary = "获取管理员列表")
    public Result<List<UserVO>> getAdminList(UserQueryRequest request) {
        return Result.success(adminService.getAdminList(request));
    }

    @PostMapping("/batch-import")
    @Operation(summary = "批量导入管理员")
    public Result<?> batchImportAdmins(@RequestBody BatchImportRequest request) {
        adminService.batchImportAdmins(request);
        return Result.success("批量导入管理员成功");
    }

    @PutMapping("/status/{id}")
    @Operation(summary = "更新管理员状态")
    public Result<?> updateAdminStatus(@PathVariable Long id, @RequestParam Integer status) {
        adminService.updateAdminStatus(id, status);
        return Result.success("更新管理员状态成功");
    }

    @PutMapping("/reset-password/{id}")
    @Operation(summary = "重置管理员密码")
    public Result<?> resetAdminPassword(@PathVariable Long id, @RequestParam String newPassword) {
        adminService.resetAdminPassword(id, newPassword);
        return Result.success("重置管理员密码成功");
    }
}
