package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 用户状态枚举
 */
@Getter
public enum UserStatusEnum implements IntegerBaseEnum{

    DISABLED(0, "禁用", "用户账号已被禁用"),
    NORMAL(1, "正常", "用户账号正常"),
    LOCKED(2, "锁定", "用户账号已被锁定"),
    PENDING(3, "待激活", "用户账号待激活");

    private final Integer code;
    private final String name;
    private final String description;

    UserStatusEnum(Integer code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static UserStatusEnum getByCode(Integer code) {
        for (UserStatusEnum status : values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }

    /**
     * 根据name获取枚举
     */
    public static UserStatusEnum getByName(String name) {
        for (UserStatusEnum status : values()) {
            if (status.getName().equals(name)) {
                return status;
            }
        }
        return null;
    }

    /**
     * 判断是否为有效状态
     */
    public static boolean isValid(Integer code) {
        return getByCode(code) != null;
    }

    /**
     * 判断用户是否可登录
     */
    public boolean canLogin() {
        return this == NORMAL || this == PENDING;
    }

    /**
     * 判断用户是否被禁用
     */
    public boolean isDisabled() {
        return this == DISABLED || this == LOCKED;
    }
}