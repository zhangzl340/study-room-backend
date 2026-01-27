package com.studyroom.modules.statistics.service.impl;

import com.studyroom.modules.statistics.dto.request.StatisticsQueryRequest;
import com.studyroom.modules.statistics.mapper.StatisticsMapper;
import com.studyroom.modules.statistics.service.UserStatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserStatisticsServiceImpl implements UserStatisticsService {

    private final StatisticsMapper statisticsMapper;

    @Override
    public Map<String, Object> getUserUsageStats(StatisticsQueryRequest request) {
        Map<String, Object> userStats = statisticsMapper.getUserUsageStats(request);
        Map<String, Object> result = new HashMap<>();
        result.put("totalUsers", userStats.getOrDefault("totalUsers", 0));
        result.put("activeUsers", userStats.getOrDefault("activeUsers", 0));
        result.put("newUsers", userStats.getOrDefault("newUsers", 0));
        result.put("averageReservations", userStats.getOrDefault("averageReservations", 0.0));
        result.put("averageCreditScore", userStats.getOrDefault("averageCreditScore", 0.0));
        result.put("userDistribution", userStats.getOrDefault("userDistribution", new HashMap<>()));
        return result;
    }

    @Override
    public List<Map<String, Object>> getUserActivityRank(StatisticsQueryRequest request) {
        return statisticsMapper.getUserActivityRank(request);
    }

    @Override
    public Map<String, Integer> getUserGrowthTrend(LocalDate startDate, LocalDate endDate) {
        // 实现用户增长趋势分析
        Map<String, Integer> growthTrend = new LinkedHashMap<>();
        // 模拟数据，实际应从数据库查询
        int userCount = 1000;
        for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
            userCount += new Random().nextInt(20) + 5;
            growthTrend.put(date.toString(), userCount);
        }
        return growthTrend;
    }

    @Override
    public Map<String, Integer> getUserTypeDistribution() {
        // 实现用户类型分布统计
        Map<String, Integer> distribution = new HashMap<>();
        // 模拟数据，实际应从数据库查询
        distribution.put("本科生", 1500);
        distribution.put("研究生", 800);
        distribution.put("教师", 150);
        distribution.put("管理员", 50);
        distribution.put("其他", 100);
        return distribution;
    }

    @Override
    public Map<String, Integer> getCreditScoreDistribution() {
        // 实现用户信用分分布统计
        Map<String, Integer> distribution = new HashMap<>();
        // 模拟数据，实际应从数据库查询
        distribution.put("90-100", 800);
        distribution.put("80-89", 1200);
        distribution.put("70-79", 600);
        distribution.put("60-69", 200);
        distribution.put("0-59", 50);
        return distribution;
    }

    @Override
    public Map<String, Object> getUserReservationBehavior(StatisticsQueryRequest request) {
        // 实现用户预约行为分析
        Map<String, Object> behavior = new HashMap<>();
        // 模拟数据，实际应从数据库查询
        Map<String, Integer> timePreference = new HashMap<>();
        timePreference.put("早晨(8:00-12:00)", 300);
        timePreference.put("下午(13:00-18:00)", 500);
        timePreference.put("晚上(19:00-22:00)", 800);
        
        Map<String, Integer> roomPreference = new HashMap<>();
        roomPreference.put("普通自习室", 1000);
        roomPreference.put("研讨室", 300);
        roomPreference.put("多媒体教室", 150);
        roomPreference.put("静音区", 600);
        
        behavior.put("timePreference", timePreference);
        behavior.put("roomPreference", roomPreference);
        behavior.put("averageReservationsPerUser", 8.5);
        behavior.put("repeatReservationRate", 75.0);
        return behavior;
    }

    @Override
    public Map<String, Object> getUserViolationStats(StatisticsQueryRequest request) {
        // 实现用户违规情况统计
        Map<String, Object> violationStats = new HashMap<>();
        // 模拟数据，实际应从数据库查询
        violationStats.put("totalViolations", 150);
        violationStats.put("violationRate", 2.5);
        violationStats.put("topViolationTypes", Map.of(
                "迟到", 60,
                "未签到", 40,
                "超时占用", 30,
                "违规占位", 20
        ));
        violationStats.put("violationUsers", 100);
        return violationStats;
    }

    @Override
    public Map<String, Double> getUserAverageUsageTime(StatisticsQueryRequest request) {
        // 实现用户平均使用时长统计
        Map<String, Double> averageTimes = new HashMap<>();
        // 模拟数据，实际应从数据库查询
        averageTimes.put("本科生", 120.5); // 分钟
        averageTimes.put("研究生", 150.8);
        averageTimes.put("教师", 90.2);
        averageTimes.put("管理员", 60.0);
        return averageTimes;
    }

    @Override
    public Map<String, Double> getUserRetentionRate(LocalDate startDate, LocalDate endDate) {
        // 实现用户留存率分析
        Map<String, Double> retentionRate = new LinkedHashMap<>();
        // 模拟数据，实际应从数据库查询
        double rate = 100.0;
        for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(7)) {
            rate *= 0.95;
            retentionRate.put(date.toString(), Math.round(rate * 100) / 100.0);
        }
        return retentionRate;
    }

    @Override
    public Map<String, Object> getUserProfileAnalysis() {
        // 实现用户画像分析
        Map<String, Object> profileAnalysis = new HashMap<>();
        // 模拟数据，实际应从数据库查询
        profileAnalysis.put("ageDistribution", Map.of(
                "18-22", 1500,
                "23-26", 800,
                "27-30", 200,
                "30+", 100
        ));
        profileAnalysis.put("genderDistribution", Map.of(
                "男", 1300,
                "女", 1300
        ));
        profileAnalysis.put("collegeDistribution", Map.of(
                "计算机学院", 500,
                "经济学院", 400,
                "文学院", 300,
                "理学院", 250,
                "其他", 1150
        ));
        profileAnalysis.put("usageFrequency", Map.of(
                "每天", 500,
                "每周3-4次", 800,
                "每周1-2次", 1000,
                "偶尔", 300
        ));
        return profileAnalysis;
    }
}
