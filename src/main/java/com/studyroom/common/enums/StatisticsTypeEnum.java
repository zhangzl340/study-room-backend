package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 统计类型枚举
 */
@Getter
public enum StatisticsTypeEnum implements StringBaseEnum{

    ROOM_USAGE("room_usage", "自习室使用率", "自习室使用情况统计"),
    SEAT_HEATMAP("seat_heatmap", "座位热度图", "座位使用热度统计"),
    USER_ACTIVITY("user_activity", "用户活跃度", "用户活跃情况统计"),
    TIME_SLOT("time_slot", "时间段统计", "不同时间段使用情况统计"),
    VIOLATION("violation", "违规统计", "违规情况统计"),
    COLLEGE_DISTRIBUTION("college_distribution", "学院分布", "各学院使用情况分布"),
    RESERVATION_TREND("reservation_trend", "预约趋势", "预约趋势统计"),
    CREDIT_DISTRIBUTION("credit_distribution", "信用分分布", "用户信用分分布情况");

    private final String code;
    private final String name;
    private final String description;

    StatisticsTypeEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static StatisticsTypeEnum getByCode(String code) {
        for (StatisticsTypeEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

    /**
     * 获取需要实时统计的类型
     */
    public static StatisticsTypeEnum[] getRealTimeTypes() {
        return new StatisticsTypeEnum[]{ROOM_USAGE, SEAT_HEATMAP};
    }

    /**
     * 获取需要每日统计的类型
     */
    public static StatisticsTypeEnum[] getDailyTypes() {
        return new StatisticsTypeEnum[]{USER_ACTIVITY, VIOLATION, RESERVATION_TREND};
    }

    /**
     * 获取需要每月统计的类型
     */
    public static StatisticsTypeEnum[] getMonthlyTypes() {
        return new StatisticsTypeEnum[]{COLLEGE_DISTRIBUTION, CREDIT_DISTRIBUTION};
    }
}