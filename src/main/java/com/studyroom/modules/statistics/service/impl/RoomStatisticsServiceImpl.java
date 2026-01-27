package com.studyroom.modules.statistics.service.impl;

import com.studyroom.modules.statistics.dto.request.StatisticsQueryRequest;
import com.studyroom.modules.statistics.dto.response.RoomUsageResponse;
import com.studyroom.modules.statistics.mapper.StatisticsMapper;
import com.studyroom.modules.statistics.service.RoomStatisticsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomStatisticsServiceImpl implements RoomStatisticsService {

    private final StatisticsMapper statisticsMapper;

    @Override
    public List<RoomUsageResponse> getRoomUsageStats(StatisticsQueryRequest request) {
        List<Map<String, Object>> roomStats = statisticsMapper.getRoomUsageStats(request);
        return roomStats.stream()
                .map(this::convertToRoomUsageResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<Map<String, Object>> getRoomUsageRank(StatisticsQueryRequest request) {
        return statisticsMapper.getRoomUsageRank(request);
    }

    @Override
    public Map<String, Map<String, Integer>> getRoomDailyTrend(LocalDate startDate, LocalDate endDate) {
        // 实现房间每日使用趋势分析
        Map<String, Map<String, Integer>> trend = new LinkedHashMap<>();
        // 模拟数据，实际应从数据库查询
        for (LocalDate date = startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1)) {
            Map<String, Integer> dailyStats = new HashMap<>();
            dailyStats.put("reservations", new Random().nextInt(100) + 50);
            dailyStats.put("checkIns", new Random().nextInt(80) + 40);
            dailyStats.put("noShows", new Random().nextInt(20));
            trend.put(date.toString(), dailyStats);
        }
        return trend;
    }

    @Override
    public Map<String, Integer> getRoomTypeDistribution() {
        // 实现房间类型分布统计
        Map<String, Integer> distribution = new HashMap<>();
        // 模拟数据，实际应从数据库查询
        distribution.put("普通自习室", 15);
        distribution.put("研讨室", 8);
        distribution.put("多媒体教室", 5);
        distribution.put("静音区", 10);
        distribution.put("开放区", 7);
        return distribution;
    }

    @Override
    public Map<String, Object> getSeatUsageStats(StatisticsQueryRequest request) {
        // 实现座位使用情况统计
        Map<String, Object> stats = new HashMap<>();
        // 模拟数据，实际应从数据库查询
        stats.put("totalSeats", 500);
        stats.put("usedSeats", 320);
        stats.put("availableSeats", 180);
        stats.put("usageRate", 64.0);
        stats.put("peakUsageRate", 85.0);
        return stats;
    }

    @Override
    public Map<String, Object> getRoomPeakHours(StatisticsQueryRequest request) {
        // 实现房间高峰期分析
        Map<String, Object> peakHours = new HashMap<>();
        List<Map<String, Integer>> hourlyStats = new ArrayList<>();
        
        // 模拟数据，实际应从数据库查询
        for (int hour = 8; hour <= 22; hour++) {
            Map<String, Integer> hourStats = new HashMap<>();
            hourStats.put("hour", hour);
            hourStats.put("usageCount", new Random().nextInt(50) + 20);
            hourlyStats.add(hourStats);
        }
        
        peakHours.put("hourlyStats", hourlyStats);
        peakHours.put("peakHour", 14);
        peakHours.put("peakCount", 65);
        return peakHours;
    }

    @Override
    public Map<String, Double> getRoomCancellationRate(StatisticsQueryRequest request) {
        // 实现房间预约取消率统计
        Map<String, Double> cancellationRates = new HashMap<>();
        // 模拟数据，实际应从数据库查询
        cancellationRates.put("普通自习室", 12.5);
        cancellationRates.put("研讨室", 8.3);
        cancellationRates.put("多媒体教室", 15.2);
        cancellationRates.put("静音区", 9.7);
        cancellationRates.put("开放区", 11.1);
        return cancellationRates;
    }

    @Override
    public Map<String, Integer> getRoomAverageUsageTime(StatisticsQueryRequest request) {
        // 实现房间平均使用时长统计
        Map<String, Integer> averageTimes = new HashMap<>();
        // 模拟数据，实际应从数据库查询
        averageTimes.put("普通自习室", 120); // 分钟
        averageTimes.put("研讨室", 90);
        averageTimes.put("多媒体教室", 150);
        averageTimes.put("静音区", 180);
        averageTimes.put("开放区", 60);
        return averageTimes;
    }

    private RoomUsageResponse convertToRoomUsageResponse(Map<String, Object> data) {
        RoomUsageResponse response = new RoomUsageResponse();
        response.setRoomId((Long) data.getOrDefault("roomId", 0L));
        response.setRoomName((String) data.getOrDefault("roomName", ""));
        response.setTotalReservations((Integer) data.getOrDefault("totalReservations", 0));
        response.setCompletedReservations((Integer) data.getOrDefault("completedReservations", 0));
        response.setUsageRate((Double) data.getOrDefault("usageRate", 0.0));
        response.setAverageStayTime((Integer) data.getOrDefault("averageStayTime", 0));
        return response;
    }
}
