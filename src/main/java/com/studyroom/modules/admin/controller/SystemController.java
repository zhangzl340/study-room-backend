package com.studyroom.modules.admin.controller;

import com.studyroom.common.result.Result;
import com.studyroom.modules.admin.dto.request.SystemSettingsUpdateRequest;
import com.studyroom.modules.admin.dto.request.ReservationRulesUpdateRequest;
import com.studyroom.modules.admin.service.SystemService;
import com.studyroom.modules.admin.vo.SystemSettingsVO;
import com.studyroom.modules.admin.vo.ReservationRulesVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin/settings")
@RequiredArgsConstructor
@Tag(name = "系统设置接口", description = "系统设置和预约规则的管理")
public class SystemController {

    private final SystemService systemService;

    @GetMapping("")
    @Operation(summary = "获取系统设置")
    public Result<SystemSettingsVO> getSystemSettings() {
        return Result.success(systemService.getSystemSettings());
    }

    @PutMapping("")
    @Operation(summary = "更新系统设置")
    public Result<SystemSettingsVO> updateSystemSettings(@RequestBody SystemSettingsUpdateRequest request) {
        return Result.success(systemService.updateSystemSettings(request));
    }

    @GetMapping("/reservation-rules")
    @Operation(summary = "获取预约规则设置")
    public Result<ReservationRulesVO> getReservationRules() {
        return Result.success(systemService.getReservationRules());
    }

    @PutMapping("/reservation-rules")
    @Operation(summary = "更新预约规则设置")
    public Result<ReservationRulesVO> updateReservationRules(@RequestBody ReservationRulesUpdateRequest request) {
        return Result.success(systemService.updateReservationRules(request));
    }

    @PostMapping("/cleanup")
    @Operation(summary = "清理过期数据")
    public Result<Map<String, Object>> cleanupExpiredData() {
        return Result.success(systemService.cleanupExpiredData());
    }

    @PostMapping("/backup")
    @Operation(summary = "备份系统数据")
    public Result<Map<String, Object>> backupData() {
        return Result.success(systemService.backupData());
    }
}
