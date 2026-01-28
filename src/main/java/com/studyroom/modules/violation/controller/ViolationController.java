package com.studyroom.modules.violation.controller;

import com.studyroom.common.result.Result;
import com.studyroom.modules.violation.dto.request.ViolationHandleRequest;
import com.studyroom.modules.violation.dto.response.ViolationRecordResponse;
import com.studyroom.modules.violation.entity.ViolationRecord;
import com.studyroom.modules.violation.service.ViolationService;
import com.studyroom.modules.violation.vo.ViolationRecordVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/violation")
@RequiredArgsConstructor
@Tag(name = "违规管理接口(管理员可用)", description = "违规记录处理管理")
public class ViolationController {

    private final ViolationService violationService;

    @PostMapping("/record")
    @Operation(summary = "记录违规")
    public Result<?> recordViolation(@RequestBody ViolationRecord violationRecord) {
        violationService.recordViolation(violationRecord);
        return Result.success("记录违规成功");
    }

    @PostMapping("/handle")
    @Operation(summary = "处理违规")
    public Result<?> handleViolation(@RequestBody ViolationHandleRequest request, 
                                   @RequestAttribute("userId") Long adminId) {
        violationService.handleViolation(request, adminId);
        return Result.success("处理违规成功");
    }

    @GetMapping("/detail/{id}")
    @Operation(summary = "获取违规记录详情")
    public Result<ViolationRecordVO> getViolationRecordDetail(@PathVariable Long id) {
        return Result.success(violationService.getViolationRecordDetail(id));
    }

    @GetMapping("/list")
    @Operation(summary = "获取违规记录列表")
    public Result<List<ViolationRecordVO>> getViolationRecordList(@RequestParam Map<String, Object> params) {
        return Result.success(violationService.getViolationRecordList(params));
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "获取用户违规记录")
    public Result<List<ViolationRecordVO>> getUserViolationRecords(@PathVariable Long userId) {
        return Result.success(violationService.getUserViolationRecords(userId));
    }

    @GetMapping("/statistics")
    @Operation(summary = "获取违规统计")
    public Result<Map<String, Object>> getViolationStatistics() {
        return Result.success(violationService.getViolationStatistics());
    }
}
