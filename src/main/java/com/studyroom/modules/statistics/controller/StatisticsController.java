package com.studyroom.modules.statistics.controller;

import com.studyroom.common.result.Result;
import com.studyroom.modules.statistics.dto.request.ExportRequest;
import com.studyroom.modules.statistics.dto.request.StatisticsQueryRequest;
import com.studyroom.modules.statistics.service.StatisticsService;
import com.studyroom.modules.statistics.service.RoomStatisticsService;
import com.studyroom.modules.statistics.service.UserStatisticsService;
import com.studyroom.modules.statistics.vo.StatisticsVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/admin/statistics")
@RequiredArgsConstructor
@Tag(name = "统计分析接口", description = "系统统计分析相关接口")
public class StatisticsController {

    private final StatisticsService statisticsService;
    private final RoomStatisticsService roomStatisticsService;
    private final UserStatisticsService userStatisticsService;

    @GetMapping("/system")
    @Operation(summary = "获取系统总体统计数据")
    public Result<?> getSystemStats() {
        return Result.success(statisticsService.getSystemStats());
    }

    @GetMapping("/room/usage")
    @Operation(summary = "获取房间使用情况统计")
    public Result<?> getRoomUsageStats(StatisticsQueryRequest request) {
        return Result.success(roomStatisticsService.getRoomUsageStats(request));
    }

    @GetMapping("/room/rank")
    @Operation(summary = "获取房间使用率排名")
    public Result<?> getRoomUsageRank(StatisticsQueryRequest request) {
        return Result.success(roomStatisticsService.getRoomUsageRank(request));
    }

    @GetMapping("/room/trend")
    @Operation(summary = "获取房间每日使用趋势")
    public Result<?> getRoomDailyTrend(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return Result.success(roomStatisticsService.getRoomDailyTrend(startDate, endDate));
    }

    @GetMapping("/room/distribution")
    @Operation(summary = "获取房间类型分布")
    public Result<?> getRoomTypeDistribution() {
        return Result.success(roomStatisticsService.getRoomTypeDistribution());
    }

    @GetMapping("/room/seat")
    @Operation(summary = "获取房间座位使用情况")
    public Result<?> getSeatUsageStats(StatisticsQueryRequest request) {
        return Result.success(roomStatisticsService.getSeatUsageStats(request));
    }

    @GetMapping("/room/peak")
    @Operation(summary = "获取房间高峰期分析")
    public Result<?> getRoomPeakHours(StatisticsQueryRequest request) {
        return Result.success(roomStatisticsService.getRoomPeakHours(request));
    }

    @GetMapping("/room/cancellation")
    @Operation(summary = "获取房间预约取消率")
    public Result<?> getRoomCancellationRate(StatisticsQueryRequest request) {
        return Result.success(roomStatisticsService.getRoomCancellationRate(request));
    }

    @GetMapping("/room/average-time")
    @Operation(summary = "获取房间平均使用时长")
    public Result<?> getRoomAverageUsageTime(StatisticsQueryRequest request) {
        return Result.success(roomStatisticsService.getRoomAverageUsageTime(request));
    }

    @GetMapping("/user/usage")
    @Operation(summary = "获取用户使用情况统计")
    public Result<?> getUserUsageStats(StatisticsQueryRequest request) {
        return Result.success(userStatisticsService.getUserUsageStats(request));
    }

    @GetMapping("/user/rank")
    @Operation(summary = "获取用户活跃度排名")
    public Result<?> getUserActivityRank(StatisticsQueryRequest request) {
        return Result.success(userStatisticsService.getUserActivityRank(request));
    }

    @GetMapping("/user/growth")
    @Operation(summary = "获取用户增长趋势")
    public Result<?> getUserGrowthTrend(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return Result.success(userStatisticsService.getUserGrowthTrend(startDate, endDate));
    }

    @GetMapping("/user/distribution")
    @Operation(summary = "获取用户类型分布")
    public Result<?> getUserTypeDistribution() {
        return Result.success(userStatisticsService.getUserTypeDistribution());
    }

    @GetMapping("/user/credit")
    @Operation(summary = "获取用户信用分分布")
    public Result<?> getCreditScoreDistribution() {
        return Result.success(userStatisticsService.getCreditScoreDistribution());
    }

    @GetMapping("/user/behavior")
    @Operation(summary = "获取用户预约行为分析")
    public Result<?> getUserReservationBehavior(StatisticsQueryRequest request) {
        return Result.success(userStatisticsService.getUserReservationBehavior(request));
    }

    @GetMapping("/user/violation")
    @Operation(summary = "获取用户违规情况统计")
    public Result<?> getUserViolationStats(StatisticsQueryRequest request) {
        return Result.success(userStatisticsService.getUserViolationStats(request));
    }

    @GetMapping("/user/average-time")
    @Operation(summary = "获取用户平均使用时长")
    public Result<?> getUserAverageUsageTime(StatisticsQueryRequest request) {
        return Result.success(userStatisticsService.getUserAverageUsageTime(request));
    }

    @GetMapping("/user/retention")
    @Operation(summary = "获取用户留存率分析")
    public Result<?> getUserRetentionRate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return Result.success(userStatisticsService.getUserRetentionRate(startDate, endDate));
    }

    @GetMapping("/user/profile")
    @Operation(summary = "获取用户画像分析")
    public Result<?> getUserProfileAnalysis() {
        return Result.success(userStatisticsService.getUserProfileAnalysis());
    }

    @GetMapping("/heatmap")
    @Operation(summary = "获取预约热力图数据")
    public Result<?> getReservationHeatmap(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return Result.success(statisticsService.getReservationHeatmap(startDate, endDate));
    }

    @GetMapping("/time-slot")
    @Operation(summary = "获取时间段使用统计")
    public Result<?> getTimeSlotStats(StatisticsQueryRequest request) {
        return Result.success(statisticsService.getTimeSlotStats(request));
    }

    @PostMapping("/export")
    @Operation(summary = "导出统计数据")
    public Result<?> exportStatistics(@RequestBody ExportRequest request) {
        byte[] data = statisticsService.exportStatistics(request.getQueryRequest(), request.getExportType());
        return Result.success(data);
    }

    @GetMapping("/snapshots")
    @Operation(summary = "获取每日统计快照")
    public Result<?> getDailySnapshots(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return Result.success(statisticsService.getDailySnapshots(startDate, endDate));
    }

    @PostMapping("/snapshot/generate")
    @Operation(summary = "生成统计快照")
    public Result<?> generateStatisticsSnapshot() {
        boolean success = statisticsService.generateStatisticsSnapshot();
        return success ? Result.success("生成统计快照成功") : Result.error("生成统计快照失败");
    }
}
