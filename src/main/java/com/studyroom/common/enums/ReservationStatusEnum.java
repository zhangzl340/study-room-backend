package com.studyroom.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 预约状态枚举
 */
@Getter
public enum ReservationStatusEnum implements StringBaseEnum{

    PENDING("pending", "待确认", "预约待系统确认"),
    CONFIRMED("confirmed", "已确认", "预约已确认"),
    CHECKED_IN("checked_in", "已签到", "用户已签到"),
    IN_USE("in_use", "使用中", "座位正在使用"),
    TEMPORARY_LEAVE("temporary_leave", "暂离", "用户暂时离开"),
    COMPLETED("completed", "已完成", "预约已完成"),
    CANCELLED("cancelled", "已取消", "预约已取消"),
    NO_SHOW("no_show", "爽约", "用户未按时签到"),
    EXPIRED("expired", "已过期", "预约已过期");

    private final String code;
    private final String name;
    private final String description;

    ReservationStatusEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static ReservationStatusEnum getByCode(String code) {
        for (ReservationStatusEnum status : values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }

    /**
     * 获取活跃状态（未完成的预约）
     */
    public static List<ReservationStatusEnum> getActiveStatus() {
        return Arrays.asList(PENDING, CONFIRMED, CHECKED_IN, IN_USE, TEMPORARY_LEAVE);
    }

    /**
     * 获取已完成状态
     */
    public static List<ReservationStatusEnum> getCompletedStatus() {
        return Arrays.asList(COMPLETED, CANCELLED, NO_SHOW, EXPIRED);
    }

    /**
     * 判断是否为活跃状态
     */
    public boolean isActive() {
        return getActiveStatus().contains(this);
    }

    /**
     * 判断是否为已完成状态
     */
    public boolean isCompleted() {
        return getCompletedStatus().contains(this);
    }

    /**
     * 判断是否可取消
     */
    public boolean canCancel() {
        return this == PENDING || this == CONFIRMED;
    }

    /**
     * 判断是否可签到
     */
    public boolean canCheckIn() {
        return this == CONFIRMED;
    }

    /**
     * 判断是否可签退
     */
    public boolean canCheckOut() {
        return this == IN_USE || this == TEMPORARY_LEAVE;
    }

    /**
     * 判断是否可暂离
     */
    public boolean canTempLeave() {
        return this == IN_USE;
    }

    /**
     * 判断是否可返回
     */
    public boolean canReturn() {
        return this == TEMPORARY_LEAVE;
    }

    /**
     * 获取状态流转的下一状态
     */
    public ReservationStatusEnum getNextStatus() {
        return switch (this) {
            case PENDING -> CONFIRMED;
            case CONFIRMED -> CHECKED_IN;
            case CHECKED_IN -> IN_USE;
            case IN_USE -> COMPLETED;
            case TEMPORARY_LEAVE -> IN_USE;
            default -> this;
        };
    }

    /**
     * 获取状态对应的颜色
     */
    public String getColor() {
        return switch (this) {
            case PENDING -> "#faad14";
            case CONFIRMED -> "#1890ff";
            case CHECKED_IN -> "#13c2c2";
            case IN_USE -> "#52c41a";
            case TEMPORARY_LEAVE -> "#722ed1";
            case COMPLETED -> "#8c8c8c";
            case CANCELLED -> "#f5222d";
            case NO_SHOW -> "#eb2f96";
            case EXPIRED -> "#d9d9d9";
        };
    }
}