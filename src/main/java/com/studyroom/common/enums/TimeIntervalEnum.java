package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 时间间隔枚举
 */
@Getter
public enum TimeIntervalEnum implements StringBaseEnum{

    HOUR("hour", "小时", "按小时统计"),
    DAY("day", "天", "按天统计"),
    WEEK("week", "周", "按周统计"),
    MONTH("month", "月", "按月统计"),
    QUARTER("quarter", "季度", "按季度统计"),
    YEAR("year", "年", "按年统计");

    private final String code;
    private final String name;
    private final String description;

    TimeIntervalEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static TimeIntervalEnum getByCode(String code) {
        for (TimeIntervalEnum interval : values()) {
            if (interval.getCode().equals(code)) {
                return interval;
            }
        }
        return DAY;
    }

    /**
     * 获取时间间隔对应的毫秒数
     */
    public long getMillis() {
        return switch (this) {
            case HOUR -> 60 * 60 * 1000L;
            case DAY -> 24 * 60 * 60 * 1000L;
            case WEEK -> 7 * 24 * 60 * 60 * 1000L;
            case MONTH -> 30 * 24 * 60 * 60 * 1000L;
            case QUARTER -> 90 * 24 * 60 * 60 * 1000L;
            case YEAR -> 365 * 24 * 60 * 60 * 1000L;
        };
    }
}