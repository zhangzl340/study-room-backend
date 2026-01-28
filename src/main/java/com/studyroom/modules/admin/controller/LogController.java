package com.studyroom.modules.admin.controller;

import com.studyroom.common.result.Result;
import com.studyroom.modules.admin.service.LogService;
import com.studyroom.modules.admin.vo.SystemLogVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/logs")
@RequiredArgsConstructor
@Tag(name = "日志管理接口", description = "系统日志的查询和管理")
public class LogController {

    private final LogService logService;

    @GetMapping("")
    @Operation(summary = "获取系统日志列表")
    public Result<List<SystemLogVO>> getSystemLogs(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) String level,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) String keyword) {
        return Result.success(logService.getSystemLogs(page, pageSize, level, startDate, endDate, keyword));
    }

    @GetMapping("/detail/{id}")
    @Operation(summary = "获取日志详情")
    public Result<SystemLogVO> getLogDetail(@PathVariable Long id) {
        return Result.success(logService.getLogDetail(id));
    }

    @DeleteMapping("/cleanup")
    @Operation(summary = "清理过期日志")
    public Result<Integer> cleanupExpiredLogs(@RequestParam Integer days) {
        return Result.success(logService.cleanupExpiredLogs(days));
    }

    @GetMapping("/statistics")
    @Operation(summary = "获取日志统计")
    public Result<?> getLogStatistics() {
        return Result.success(logService.getLogStatistics());
    }
}
