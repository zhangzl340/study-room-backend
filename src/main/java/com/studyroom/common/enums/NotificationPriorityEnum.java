package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 通知优先级枚举
 */
@Getter
public enum NotificationPriorityEnum implements IntegerBaseEnum{

    LOW(1, "低", "低优先级通知"),
    NORMAL(2, "普通", "普通优先级通知"),
    HIGH(3, "高", "高优先级通知"),
    URGENT(4, "紧急", "紧急优先级通知");

    private final Integer code;
    private final String name;
    private final String description;

    NotificationPriorityEnum(Integer code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static NotificationPriorityEnum getByCode(Integer code) {
        for (NotificationPriorityEnum priority : values()) {
            if (priority.getCode().equals(code)) {
                return priority;
            }
        }
        return NORMAL;
    }

    /**
     * 判断是否为紧急通知
     */
    public boolean isUrgent() {
        return this == URGENT;
    }

    /**
     * 判断是否需要立即推送
     */
    public boolean requiresImmediatePush() {
        return this == URGENT || this == HIGH;
    }
}