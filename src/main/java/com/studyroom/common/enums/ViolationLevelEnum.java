package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 违规等级枚举
 */
@Getter
public enum ViolationLevelEnum implements StringBaseEnum {

    MINOR("minor", "轻微", "轻微的违规行为，警告处理"),
    MEDIUM("medium", "中等", "中等程度的违规行为，扣分处理"),
    MAJOR("major", "严重", "严重的违规行为，限制预约"),
    SERIOUS("serious", "非常严重", "非常严重的违规行为，账号封禁");

    private final String code;
    private final String name;
    private final String description;

    ViolationLevelEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static ViolationLevelEnum getByCode(String code) {
        for (ViolationLevelEnum level : values()) {
            if (level.getCode().equals(code)) {
                return level;
            }
        }
        return MINOR;
    }

    /**
     * 获取等级对应的处理措施
     */
    public String getAction() {
        return switch (this) {
            case MINOR -> "警告";
            case MEDIUM -> "扣分";
            case MAJOR -> "限制预约7天";
            case SERIOUS -> "账号封禁30天";
        };
    }

    /**
     * 判断是否需要通知管理员
     */
    public boolean requiresAdminNotification() {
        return this == MAJOR || this == SERIOUS;
    }
}