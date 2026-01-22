package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 是否枚举
 */
@Getter
public enum YesNoEnum implements IntegerBaseEnum{

    NO(0, "否", "表示否"),
    YES(1, "是", "表示是");

    private final Integer code;
    private final String name;
    private final String description;

    YesNoEnum(Integer code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static YesNoEnum getByCode(Integer code) {
        for (YesNoEnum yn : values()) {
            if (yn.getCode().equals(code)) {
                return yn;
            }
        }
        return NO;
    }

    /**
     * 根据布尔值获取枚举
     */
    public static YesNoEnum fromBoolean(Boolean value) {
        return Boolean.TRUE.equals(value) ? YES : NO;
    }

    /**
     * 转换为布尔值
     */
    public boolean toBoolean() {
        return this == YES;
    }
}