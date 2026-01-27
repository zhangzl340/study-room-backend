package com.studyroom.modules.statistics.service;

import com.studyroom.modules.statistics.dto.request.StatisticsQueryRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface UserStatisticsService {

    /**
     * 获取用户使用情况统计
     */
    Map<String, Object> getUserUsageStats(StatisticsQueryRequest request);

    /**
     * 获取用户活跃度排名
     */
    List<Map<String, Object>> getUserActivityRank(StatisticsQueryRequest request);

    /**
     * 获取用户增长趋势
     */
    Map<String, Integer> getUserGrowthTrend(LocalDate startDate, LocalDate endDate);

    /**
     * 获取用户类型分布
     */
    Map<String, Integer> getUserTypeDistribution();

    /**
     * 获取用户信用分分布
     */
    Map<String, Integer> getCreditScoreDistribution();

    /**
     * 获取用户预约行为分析
     */
    Map<String, Object> getUserReservationBehavior(StatisticsQueryRequest request);

    /**
     * 获取用户违规情况统计
     */
    Map<String, Object> getUserViolationStats(StatisticsQueryRequest request);

    /**
     * 获取用户平均使用时长
     */
    Map<String, Double> getUserAverageUsageTime(StatisticsQueryRequest request);

    /**
     * 获取用户留存率分析
     */
    Map<String, Double> getUserRetentionRate(LocalDate startDate, LocalDate endDate);

    /**
     * 获取用户画像分析
     */
    Map<String, Object> getUserProfileAnalysis();
}
