package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 通知类型枚举
 */
@Getter
public enum NotificationTypeEnum implements StringBaseEnum{

    RESERVATION("reservation", "预约通知", "预约相关的通知"),
    CHECKIN("checkin", "签到通知", "签到签退相关的通知"),
    VIOLATION("violation", "违规通知", "违规处理相关的通知"),
    ANNOUNCEMENT("announcement", "公告通知", "系统公告通知"),
    REMINDER("reminder", "提醒通知", "预约提醒通知"),
    SYSTEM("system", "系统通知", "系统相关的通知"),
    CREDIT("credit", "信用分通知", "信用分变动通知"),
    WARNING("warning", "警告通知", "系统警告通知");

    private final String code;
    private final String name;
    private final String description;

    NotificationTypeEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static NotificationTypeEnum getByCode(String code) {
        for (NotificationTypeEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return SYSTEM;
    }

    /**
     * 获取通知类型的图标
     */
    public String getIcon() {
        return switch (this) {
            case RESERVATION -> "calendar";
            case CHECKIN -> "check-circle";
            case VIOLATION -> "warning";
            case ANNOUNCEMENT -> "sound";
            case REMINDER -> "bell";
            case SYSTEM -> "setting";
            case CREDIT -> "star";
            case WARNING -> "exclamation-circle";
        };
    }

    /**
     * 获取通知类型的颜色
     */
    public String getColor() {
        return switch (this) {
            case RESERVATION -> "#1890ff";
            case CHECKIN -> "#52c41a";
            case VIOLATION -> "#f5222d";
            case ANNOUNCEMENT -> "#fa8c16";
            case REMINDER -> "#722ed1";
            case SYSTEM -> "#8c8c8c";
            case CREDIT -> "#13c2c2";
            case WARNING -> "#faad14";
        };
    }

    /**
     * 判断是否为重要通知
     */
    public boolean isImportant() {
        return this == VIOLATION || this == WARNING || this == SYSTEM;
    }

    /**
     * 判断是否为提醒类通知
     */
    public boolean isReminder() {
        return this == REMINDER || this == CHECKIN;
    }
}