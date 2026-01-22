package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 签到操作枚举
 */
@Getter
public enum CheckInActionEnum implements StringBaseEnum {

    CHECK_IN("check_in", "签到", "用户签到操作"),
    CHECK_OUT("check_out", "签退", "用户签退操作"),
    TEMPORARY_LEAVE("temporary_leave", "暂离", "用户暂时离开"),
    RETURN("return", "返回", "用户从暂离返回"),
    FORCE_CHECKOUT("force_checkout", "强制签退", "管理员强制签退"),
    AUTO_CHECKOUT("auto_checkout", "自动签退", "系统自动签退");

    private final String code;
    private final String name;
    private final String description;

    CheckInActionEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static CheckInActionEnum getByCode(String code) {
        for (CheckInActionEnum action : values()) {
            if (action.getCode().equals(code)) {
                return action;
            }
        }
        return null;
    }

    /**
     * 判断是否为签到操作
     */
    public boolean isCheckIn() {
        return this == CHECK_IN;
    }

    /**
     * 判断是否为签退操作
     */
    public boolean isCheckOut() {
        return this == CHECK_OUT || this == FORCE_CHECKOUT || this == AUTO_CHECKOUT;
    }

    /**
     * 判断是否为暂离相关操作
     */
    public boolean isLeaveRelated() {
        return this == TEMPORARY_LEAVE || this == RETURN;
    }

    /**
     * 判断是否为自动操作
     */
    public boolean isAuto() {
        return this == AUTO_CHECKOUT;
    }

    /**
     * 判断是否为强制操作
     */
    public boolean isForced() {
        return this == FORCE_CHECKOUT;
    }
}