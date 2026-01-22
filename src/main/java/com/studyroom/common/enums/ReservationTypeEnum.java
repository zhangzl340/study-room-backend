package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 预约类型枚举
 */
@Getter
public enum ReservationTypeEnum implements StringBaseEnum{

    NORMAL("normal", "普通预约", "常规自习预约"),
    IMMEDIATE("immediate", "即时预约", "立即开始的预约"),
    RECURRING("recurring", "重复预约", "周期性重复预约"),
    GROUP("group", "小组预约", "小组学习预约"),
    EXAM("exam", "考试预约", "考试专用预约");

    private final String code;
    private final String name;
    private final String description;

    ReservationTypeEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static ReservationTypeEnum getByCode(String code) {
        for (ReservationTypeEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return NORMAL;
    }

    /**
     * 判断是否为即时预约
     */
    public boolean isImmediate() {
        return this == IMMEDIATE;
    }

    /**
     * 判断是否为重复预约
     */
    public boolean isRecurring() {
        return this == RECURRING;
    }

    /**
     * 判断是否支持取消
     */
    public boolean canCancel() {
        return this != EXAM; // 考试预约不可取消
    }
}