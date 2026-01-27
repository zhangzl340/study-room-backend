package com.studyroom.modules.reservation.controller;

import com.studyroom.common.result.Result;
import com.studyroom.modules.reservation.dto.request.ReservationCancelRequest;
import com.studyroom.modules.reservation.dto.request.ReservationCheckRequest;
import com.studyroom.modules.reservation.dto.request.ReservationCreateRequest;
import com.studyroom.modules.reservation.dto.request.ReservationQueryRequest;
import com.studyroom.modules.reservation.dto.response.AvailabilityResponse;
import com.studyroom.modules.reservation.service.ReservationService;
import com.studyroom.modules.reservation.vo.ReservationVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/student/reservation")
@RequiredArgsConstructor
@Tag(name = "学生预约接口", description = "学生预约创建取消操作")
public class StudentReservationController {

    private final ReservationService reservationService;

    @PostMapping("/create")
    @Operation(summary = "创建预约")
    public Result<?> createReservation(@RequestBody ReservationCreateRequest request, 
                                      @RequestAttribute("userId") Long userId) {
        reservationService.createReservation(request, userId);
        return Result.success("创建预约成功");
    }

    @PostMapping("/cancel")
    @Operation(summary = "取消预约")
    public Result<?> cancelReservation(@RequestBody ReservationCancelRequest request, 
                                       @RequestAttribute("userId") Long userId) {
        reservationService.cancelReservation(request, userId);
        return Result.success("取消预约成功");
    }

    @PostMapping("/check")
    @Operation(summary = "确认预约")
    public Result<?> checkReservation(@RequestBody ReservationCheckRequest request, 
                                      @RequestAttribute("userId") Long userId) {
        reservationService.checkReservation(request, userId);
        return Result.success("确认预约成功");
    }

    @GetMapping("/detail/{id}")
    @Operation(summary = "获取预约详情")
    public Result<ReservationVO> getReservationDetail(@PathVariable Long id, 
                                                     @RequestAttribute("userId") Long userId) {
        return Result.success(reservationService.getReservationDetail(id, userId));
    }

    @GetMapping("/list")
    @Operation(summary = "获取用户预约列表")
    public Result<List<ReservationVO>> getUserReservations(ReservationQueryRequest request, 
                                                          @RequestAttribute("userId") Long userId) {
        return Result.success(reservationService.getUserReservations(request, userId));
    }

    @GetMapping("/availability")
    @Operation(summary = "检查座位可用性")
    public Result<AvailabilityResponse> checkSeatAvailability(@RequestParam Long roomId, 
                                                              @RequestParam Long seatId, 
                                                              @RequestParam String startTime, 
                                                              @RequestParam String endTime) {
        LocalDateTime start = LocalDateTime.parse(startTime);
        LocalDateTime end = LocalDateTime.parse(endTime);
        return Result.success(reservationService.checkSeatAvailability(roomId, seatId, start, end));
    }

    @GetMapping("/fee")
    @Operation(summary = "计算预约费用")
    public Result<Double> calculateReservationFee(@RequestBody ReservationCreateRequest request) {
        double fee = reservationService.calculateReservationFee(request);
        return Result.success(fee);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "更新预约")
    public Result<?> updateReservation(@PathVariable Long id, 
                                      @RequestBody ReservationCreateRequest request, 
                                      @RequestAttribute("userId") Long userId) {
        reservationService.updateReservation(id, request, userId);
        return Result.success("更新预约成功");
    }

    @GetMapping("/upcoming")
    @Operation(summary = "获取即将开始的预约")
    public Result<List<ReservationVO>> getUpcomingReservations(@RequestAttribute("userId") Long userId) {
        return Result.success(reservationService.getUpcomingReservations(userId));
    }

    @GetMapping("/statistics")
    @Operation(summary = "获取预约统计")
    public Result<?> getReservationStatistics() {
        return Result.success(reservationService.getTodayReservationStatistics());
    }
}
