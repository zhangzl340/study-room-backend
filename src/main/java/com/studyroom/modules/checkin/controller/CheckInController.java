package com.studyroom.modules.checkin.controller;

import com.studyroom.common.result.Result;
import com.studyroom.modules.checkin.service.CheckInService;
import com.studyroom.modules.checkin.vo.CheckInRecordVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/checkin")
@RequiredArgsConstructor
@Tag(name = "签到管理接口(管理员可用)", description = "签到记录查询统计管理")
public class CheckInController {

    private final CheckInService checkInService;

    @GetMapping("/list")
    @Operation(summary = "获取签到记录列表")
    public Result<List<CheckInRecordVO>> getCheckInRecordList(@RequestParam Map<String, Object> params) {
        return Result.success(checkInService.getCheckInRecordList(params));
    }

    @GetMapping("/detail/{id}")
    @Operation(summary = "获取签到记录详情")
    public Result<CheckInRecordVO> getCheckInRecordDetail(@PathVariable Long id) {
        return Result.success(checkInService.getCheckInRecordDetail(id, null));
    }

    @GetMapping("/statistics")
    @Operation(summary = "获取签到统计")
    public Result<Map<String, Object>> getCheckInStatistics() {
        return Result.success(checkInService.getCheckInStatistics());
    }

    @PostMapping("/cleanup")
    @Operation(summary = "清理超时签到")
    public Result<?> cleanupOverdueCheckIns() {
        checkInService.cleanupOverdueCheckIns();
        return Result.success("清理超时签到成功");
    }
}
