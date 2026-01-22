package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 自习室状态枚举
 */
@Getter
public enum RoomStatusEnum implements IntegerBaseEnum {

    CLOSED(0, "关闭", "自习室已关闭，不可预约"),
    OPEN(1, "开放", "自习室正常开放"),
    MAINTENANCE(2, "维护中", "自习室正在维护"),
    EXAM(3, "考试专用", "自习室用于考试"),
    SPECIAL(4, "特殊用途", "自习室有特殊用途");

    private final Integer code;
    private final String name;
    private final String description;

    RoomStatusEnum(Integer code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static RoomStatusEnum getByCode(Integer code) {
        for (RoomStatusEnum status : values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }

    /**
     * 判断是否可预约
     */
    public boolean canReserve() {
        return this == OPEN;
    }

    /**
     * 判断是否可见
     */
    public boolean isVisible() {
        return this != CLOSED;
    }

    /**
     * 获取所有可预约的状态
     */
    public static RoomStatusEnum[] getReservableStatus() {
        return new RoomStatusEnum[]{OPEN};
    }
}