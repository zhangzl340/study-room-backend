package com.studyroom.modules.statistics.service;

import com.studyroom.modules.statistics.dto.request.StatisticsQueryRequest;
import com.studyroom.modules.statistics.dto.response.RoomUsageResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface RoomStatisticsService {

    /**
     * 获取房间使用情况统计
     */
    List<RoomUsageResponse> getRoomUsageStats(StatisticsQueryRequest request);

    /**
     * 获取房间使用率排名
     */
    List<Map<String, Object>> getRoomUsageRank(StatisticsQueryRequest request);

    /**
     * 获取房间每日使用趋势
     */
    Map<String, Map<String, Integer>> getRoomDailyTrend(LocalDate startDate, LocalDate endDate);

    /**
     * 获取房间类型分布
     */
    Map<String, Integer> getRoomTypeDistribution();

    /**
     * 获取房间座位使用情况
     */
    Map<String, Object> getSeatUsageStats(StatisticsQueryRequest request);

    /**
     * 获取房间高峰期分析
     */
    Map<String, Object> getRoomPeakHours(StatisticsQueryRequest request);

    /**
     * 获取房间预约取消率
     */
    Map<String, Double> getRoomCancellationRate(StatisticsQueryRequest request);

    /**
     * 获取房间平均使用时长
     */
    Map<String, Integer> getRoomAverageUsageTime(StatisticsQueryRequest request);
}
