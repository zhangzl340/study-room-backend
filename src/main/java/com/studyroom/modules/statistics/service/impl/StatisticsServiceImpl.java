package com.studyroom.modules.statistics.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.studyroom.modules.statistics.dto.request.StatisticsQueryRequest;
import com.studyroom.modules.statistics.dto.response.*;
import com.studyroom.modules.statistics.entity.StatisticsSnapshot;
import com.studyroom.modules.statistics.mapper.StatisticsMapper;
import com.studyroom.modules.statistics.service.StatisticsService;
import com.studyroom.modules.statistics.vo.StatisticsVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl extends ServiceImpl<StatisticsMapper, StatisticsSnapshot> implements StatisticsService {

    private final StatisticsMapper statisticsMapper;

    @Override
    public SystemStatsResponse getSystemStats() {
        Map<String, Object> stats = statisticsMapper.getSystemStats();
        SystemStatsResponse response = new SystemStatsResponse();
        response.setTotalUsers((Integer) stats.getOrDefault("totalUsers", 0));
        response.setActiveUsers((Integer) stats.getOrDefault("activeUsers", 0));
        response.setTotalReservations((Integer) stats.getOrDefault("totalReservations", 0));
        response.setTotalCheckIns((Integer) stats.getOrDefault("totalCheckIns", 0));
        response.setTotalViolations((Integer) stats.getOrDefault("totalViolations", 0));
        response.setTodayReservations((Integer) stats.getOrDefault("todayReservations", 0));
        response.setTodayCheckIns((Integer) stats.getOrDefault("todayCheckIns", 0));
        response.setTodayViolations((Integer) stats.getOrDefault("todayViolations", 0));
        response.setAverageUsageRate((Double) stats.getOrDefault("averageUsageRate", 0.0));
        return response;
    }

    @Override
    public List<RoomUsageResponse> getRoomUsageStats(StatisticsQueryRequest request) {
        List<Map<String, Object>> roomStats = statisticsMapper.getRoomUsageStats(request);
        return roomStats.stream().map(this::convertToRoomUsageResponse).collect(Collectors.toList());
    }

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
    public HeatmapResponse getReservationHeatmap(LocalDate startDate, LocalDate endDate) {
        List<Map<String, Object>> heatmapData = statisticsMapper.getReservationHeatmap(startDate, endDate);
        HeatmapResponse response = new HeatmapResponse();
        List<HeatmapResponse.DataPoint> dataPoints = heatmapData.stream()
                .map(this::convertToHeatmapDataPoint)
                .collect(Collectors.toList());
        response.setDataPoints(dataPoints);
        response.setStartDate(startDate);
        response.setEndDate(endDate);
        return response;
    }

    @Override
    public Map<String, Integer> getTimeSlotStats(StatisticsQueryRequest request) {
        List<Map<String, Object>> timeSlotData = statisticsMapper.getTimeSlotStats(request);
        Map<String, Integer> result = new LinkedHashMap<>();
        // 初始化时间段
        String[] timeSlots = {
                "08:00-09:00", "09:00-10:00", "10:00-11:00", "11:00-12:00",
                "12:00-13:00", "13:00-14:00", "14:00-15:00", "15:00-16:00",
                "16:00-17:00", "17:00-18:00", "18:00-19:00", "19:00-20:00",
                "20:00-21:00", "21:00-22:00"
        };
        for (String slot : timeSlots) {
            result.put(slot, 0);
        }
        // 填充数据
        for (Map<String, Object> data : timeSlotData) {
            String timeSlot = (String) data.get("timeSlot");
            Integer count = (Integer) data.get("count");
            if (timeSlot != null && count != null) {
                result.put(timeSlot, count);
            }
        }
        return result;
    }

    @Override
    public byte[] exportStatistics(StatisticsQueryRequest request, String exportType) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // 根据导出类型生成不同格式的数据
            if ("excel".equals(exportType)) {
                // 实现Excel导出逻辑
                log.info("导出Excel统计数据");
            } else if ("csv".equals(exportType)) {
                // 实现CSV导出逻辑
                log.info("导出CSV统计数据");
            } else if ("pdf".equals(exportType)) {
                // 实现PDF导出逻辑
                log.info("导出PDF统计数据");
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            log.error("导出统计数据失败", e);
            return new byte[0];
        }
    }

    @Override
    public List<StatisticsVO> getDailySnapshots(LocalDate startDate, LocalDate endDate) {
        List<StatisticsSnapshot> snapshots = statisticsMapper.getDailySnapshots(startDate, endDate);
        return snapshots.stream()
                .map(this::convertToStatisticsVO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean generateStatisticsSnapshot() {
        StatisticsSnapshot snapshot = new StatisticsSnapshot();
        snapshot.setSnapshotType("DAILY");
        snapshot.setSnapshotDate(LocalDate.now());
        snapshot.setCreateTime(LocalDateTime.now());
        
        // 获取今日统计数据
        Map<String, Object> todayStats = new HashMap<>();
        todayStats.put("totalUsers", statisticsMapper.getSystemStats().getOrDefault("totalUsers", 0));
        todayStats.put("todayReservations", statisticsMapper.getTodayReservationCount());
        todayStats.put("todayCheckIns", statisticsMapper.getTodayCheckInCount());
        todayStats.put("todayViolations", statisticsMapper.getTodayViolationCount());
        
        // 将统计数据转换为JSON字符串存储
        String dataJson = com.alibaba.fastjson2.JSON.toJSONString(todayStats);
        snapshot.setDataJson(dataJson);
        
        // 设置基本统计字段
        snapshot.setTotalUsers((Integer) todayStats.getOrDefault("totalUsers", 0));
        snapshot.setTotalReservations((Integer) todayStats.getOrDefault("todayReservations", 0));
        snapshot.setTotalCheckIns((Integer) todayStats.getOrDefault("todayCheckIns", 0));
        snapshot.setTotalViolations((Integer) todayStats.getOrDefault("todayViolations", 0));
        
        boolean saved = save(snapshot);
        if (saved) {
            log.info("生成统计快照成功: {}", snapshot.getSnapshotDate());
        }
        return saved;
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

    private HeatmapResponse.DataPoint convertToHeatmapDataPoint(Map<String, Object> data) {
        HeatmapResponse.DataPoint dataPoint = new HeatmapResponse.DataPoint();
        dataPoint.setDate((LocalDate) data.getOrDefault("date", LocalDate.now()));
        dataPoint.setHour((Integer) data.getOrDefault("hour", 0));
        dataPoint.setValue((Integer) data.getOrDefault("value", 0));
        return dataPoint;
    }

    private StatisticsVO convertToStatisticsVO(StatisticsSnapshot snapshot) {
        StatisticsVO vo = new StatisticsVO();
        vo.setId(snapshot.getId());
        vo.setSnapshotDate(snapshot.getSnapshotDate());
        vo.setTotalUsers(snapshot.getTotalUsers());
        vo.setTotalReservations(snapshot.getTotalReservations());
        vo.setTotalCheckIns(snapshot.getTotalCheckIns());
        vo.setTotalViolations(snapshot.getTotalViolations());
        vo.setCreateTime(snapshot.getCreateTime());
        return vo;
    }
}
