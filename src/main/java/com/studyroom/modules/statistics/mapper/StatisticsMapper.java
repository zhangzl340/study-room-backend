package com.studyroom.modules.statistics.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.studyroom.modules.statistics.entity.StatisticsSnapshot;
import com.studyroom.modules.statistics.dto.request.StatisticsQueryRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface StatisticsMapper extends BaseMapper<StatisticsSnapshot> {

    /**
     * 获取系统总体统计数据
     */
    Map<String, Object> getSystemStats();

    /**
     * 获取房间使用情况统计
     */
    List<Map<String, Object>> getRoomUsageStats(@Param("request") StatisticsQueryRequest request);

    /**
     * 获取用户使用情况统计
     */
    Map<String, Object> getUserUsageStats(@Param("request") StatisticsQueryRequest request);

    /**
     * 获取预约热力图数据
     */
    List<Map<String, Object>> getReservationHeatmap(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    /**
     * 获取时间段使用统计
     */
    List<Map<String, Object>> getTimeSlotStats(@Param("request") StatisticsQueryRequest request);

    /**
     * 获取每日统计快照
     */
    List<StatisticsSnapshot> getDailySnapshots(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    /**
     * 获取今日预约数
     */
    Integer getTodayReservationCount();

    /**
     * 获取今日签到数
     */
    Integer getTodayCheckInCount();

    /**
     * 获取今日违规数
     */
    Integer getTodayViolationCount();

    /**
     * 获取房间使用率排名
     */
    List<Map<String, Object>> getRoomUsageRank(@Param("request") StatisticsQueryRequest request);

    /**
     * 获取用户活跃度排名
     */
    List<Map<String, Object>> getUserActivityRank(@Param("request") StatisticsQueryRequest request);
}
