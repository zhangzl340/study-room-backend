package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 签到状态枚举
 */
@Getter
public enum CheckInStatusEnum implements IntegerBaseEnum{

    NORMAL(1, "正常签到", "按时签到"),
    LATE(2, "迟到", "超过规定时间签到"),
    EARLY(3, "提前", "在规定时间前签到"),
    ABSENT(4, "缺勤", "未签到"),
    EXCEPTION(5, "异常", "签到异常");

    private final Integer code;
    private final String name;
    private final String description;

    CheckInStatusEnum(Integer code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static CheckInStatusEnum getByCode(Integer code) {
        for (CheckInStatusEnum status : values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }

    /**
     * 判断是否为正常状态
     */
    public boolean isNormal() {
        return this == NORMAL || this == EARLY;
    }

    /**
     * 判断是否为异常状态
     */
    public boolean isAbnormal() {
        return this == LATE || this == ABSENT || this == EXCEPTION;
    }

    /**
     * 判断是否会影响信用分
     */
    public boolean affectsCredit() {
        return this == LATE || this == ABSENT;
    }
}