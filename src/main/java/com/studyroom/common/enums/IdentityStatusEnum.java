package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 实名认证状态枚举
 */
@Getter
public enum IdentityStatusEnum implements IntegerBaseEnum{

    UNVERIFIED(0, "未认证", "用户未进行实名认证"),
    VERIFIED(1, "已认证", "用户已完成实名认证"),
    PENDING(2, "审核中", "用户实名认证正在审核"),
    FAILED(3, "认证失败", "用户实名认证未通过");

    private final Integer code;
    private final String name;
    private final String description;

    IdentityStatusEnum(Integer code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static IdentityStatusEnum getByCode(Integer code) {
        for (IdentityStatusEnum status : values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }

    /**
     * 判断是否已认证
     */
    public boolean isVerified() {
        return this == VERIFIED;
    }

    /**
     * 判断是否在审核中
     */
    public boolean isPending() {
        return this == PENDING;
    }

    /**
     * 判断是否未认证
     */
    public boolean isUnverified() {
        return this == UNVERIFIED;
    }

    /**
     * 判断认证是否失败
     */
    public boolean isFailed() {
        return this == FAILED;
    }
}