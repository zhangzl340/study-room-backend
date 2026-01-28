package com.studyroom.modules.reservation.controller;

import com.studyroom.common.result.Result;
import com.studyroom.modules.reservation.dto.request.ReservationQueryRequest;
import com.studyroom.modules.reservation.service.ReservationService;
import com.studyroom.modules.reservation.vo.ReservationVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/reservation")
@RequiredArgsConstructor
@Tag(name = "预约管理接口(管理员可用)", description = "预约列表查询状态管理")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/list")
    @Operation(summary = "获取预约列表")
    public Result<List<ReservationVO>> getReservationList(ReservationQueryRequest request) {
        return Result.success(reservationService.getReservationList(request));
    }

    @GetMapping("/detail/{id}")
    @Operation(summary = "获取预约详情")
    public Result<ReservationVO> getReservationDetail(@PathVariable Long id) {
        // 管理员可以查看所有预约
        return Result.success(reservationService.getReservationDetail(id, null));
    }

    @PutMapping("/status/{id}")
    @Operation(summary = "更新预约状态")
    public Result<?> updateReservationStatus(@PathVariable Long id, @RequestParam String status) {
        reservationService.updateReservationStatus(id, status);
        return Result.success("更新预约状态成功");
    }

    @GetMapping("/statistics")
    @Operation(summary = "获取预约统计")
    public Result<Map<String, Object>> getReservationStatistics() {
        return Result.success(reservationService.getReservationStatistics());
    }

    @PostMapping("/cleanup")
    @Operation(summary = "清理过期预约")
    public Result<?> cleanupExpiredReservations() {
        reservationService.cleanupExpiredReservations();
        return Result.success("清理过期预约成功");
    }
}
