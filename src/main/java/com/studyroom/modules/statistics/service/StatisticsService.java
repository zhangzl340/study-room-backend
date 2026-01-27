package com.studyroom.modules.statistics.service;

import com.studyroom.modules.statistics.dto.request.StatisticsQueryRequest;
import com.studyroom.modules.statistics.dto.response.*;
import com.studyroom.modules.statistics.vo.StatisticsVO;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface StatisticsService {

    /**
     * 获取系统总体统计数据
     */
    SystemStatsResponse getSystemStats();

    /**
     * 获取房间使用情况统计
     */
    List<RoomUsageResponse> getRoomUsageStats(StatisticsQueryRequest request);

    /**
     * 获取用户使用情况统计
     */
    Map<String, Object> getUserUsageStats(StatisticsQueryRequest request);

    /**
     * 获取预约热力图数据
     */
    HeatmapResponse getReservationHeatmap(LocalDate startDate, LocalDate endDate);

    /**
     * 获取时间段使用统计
     */
    Map<String, Integer> getTimeSlotStats(StatisticsQueryRequest request);

    /**
     * 导出统计数据
     */
    byte[] exportStatistics(StatisticsQueryRequest request, String exportType);

    /**
     * 获取每日统计快照
     */
    List<StatisticsVO> getDailySnapshots(LocalDate startDate, LocalDate endDate);

    /**
     * 生成统计快照
     */
    boolean generateStatisticsSnapshot();
}
