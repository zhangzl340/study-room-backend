package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 性别枚举
 */
@Getter
public enum GenderEnum implements IntegerBaseEnum{

    UNKNOWN(0, "未知", "性别未知"),
    MALE(1, "男", "男性"),
    FEMALE(2, "女", "女性");

    private final Integer code;
    private final String name;
    private final String description;

    GenderEnum(Integer code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static GenderEnum getByCode(Integer code) {
        for (GenderEnum gender : values()) {
            if (gender.getCode().equals(code)) {
                return gender;
            }
        }
        return UNKNOWN;
    }

    /**
     * 根据name获取枚举
     */
    public static GenderEnum getByName(String name) {
        for (GenderEnum gender : values()) {
            if (gender.getName().equals(name)) {
                return gender;
            }
        }
        return UNKNOWN;
    }
}