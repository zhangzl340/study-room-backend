package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 座位状态枚举
 */
@Getter
public enum SeatStatusEnum implements StringBaseEnum{

    AVAILABLE("available", "available", "可用", "座位空闲，可预约"),
    RESERVED("reserved", "reserved", "已预约", "座位已被预约"),
    IN_USE("in_use", "in_use", "使用中", "座位正在被使用"),
    TEMPORARY_LEAVE("maintenance", "temporary_leave", "暂离", "用户暂时离开"),
    MAINTENANCE("unavailable", "maintenance", "维护中", "座位正在维护"),
    UNAVAILABLE("temporary_leave", "unavailable", "不可用", "座位不可用");

    private final String code;
    private final String status;
    private final String name;
    private final String description;

    SeatStatusEnum(String code, String status, String name, String description) {
        this.code = code;
        this.status = status;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static SeatStatusEnum getByCode(String  code) {
        for (SeatStatusEnum statusEnum : values()) {
            if (statusEnum.getCode().equals(code)) {
                return statusEnum;
            }
        }
        return null;
    }

    /**
     * 根据status字符串获取枚举
     */
    public static SeatStatusEnum getByStatus(String status) {
        for (SeatStatusEnum statusEnum : values()) {
            if (statusEnum.getStatus().equals(status)) {
                return statusEnum;
            }
        }
        return null;
    }

    /**
     * 判断座位是否可用（可预约）
     */
    public boolean isAvailable() {
        return this == AVAILABLE;
    }

    /**
     * 判断座位是否被占用（包括预约和使用中）
     */
    public boolean isOccupied() {
        return this == RESERVED || this == IN_USE || this == TEMPORARY_LEAVE;
    }

    /**
     * 判断座位是否正在使用
     */
    public boolean isInUse() {
        return this == IN_USE || this == TEMPORARY_LEAVE;
    }

    /**
     * 判断座位是否可签退
     */
    public boolean canCheckOut() {
        return this == IN_USE || this == TEMPORARY_LEAVE;
    }

    /**
     * 判断座位是否可暂离
     */
    public boolean canTempLeave() {
        return this == IN_USE;
    }

    /**
     * 判断座位是否可返回
     */
    public boolean canReturn() {
        return this == TEMPORARY_LEAVE;
    }

    /**
     * 获取状态对应的颜色
     */
    public String getColor() {
        return switch (this) {
            case AVAILABLE -> "#52c41a";
            case RESERVED -> "#faad14";
            case IN_USE -> "#1890ff";
            case TEMPORARY_LEAVE -> "#722ed1";
            case MAINTENANCE -> "#f5222d";
            case UNAVAILABLE -> "#8c8c8c";
        };
    }

    /**
     * 获取状态对应的图标
     */
    public String getIcon() {
        return switch (this) {
            case AVAILABLE -> "check-circle";
            case RESERVED -> "clock-circle";
            case IN_USE -> "user";
            case TEMPORARY_LEAVE -> "logout";
            case MAINTENANCE -> "tool";
            case UNAVAILABLE -> "close-circle";
        };
    }
}