package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 座位类型枚举
 */
@Getter
public enum SeatTypeEnum implements StringBaseEnum{

    NORMAL("normal", "普通座位", "标准自习座位", "#1890ff"),
    VIP("vip", "VIP座位", "带电源和台灯的座位", "#52c41a"),
    DISABLED("disabled", "无障碍座位", "方便残障人士使用的座位", "#fa8c16"),
    STANDING("standing", "站立座位", "适合短时间使用的站立桌", "#722ed1"),
    GROUP("group", "小组座位", "适合小组讨论的座位", "#eb2f96"),
    WINDOW("window", "窗边座位", "靠窗的安静座位", "#13c2c2");

    private final String code;
    private final String name;
    private final String description;
    private final String color;

    SeatTypeEnum(String code, String name, String description, String color) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.color = color;
    }

    /**
     * 根据code获取枚举
     */
    public static SeatTypeEnum getByCode(String code) {
        for (SeatTypeEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return NORMAL;
    }

    /**
     * 获取前端显示的颜色
     */
    public static String getColorByCode(String code) {
        SeatTypeEnum type = getByCode(code);
        return type != null ? type.getColor() : "#1890ff";
    }

    /**
     * 判断是否需要电源
     */
    public boolean requiresPower() {
        return this == VIP || this == GROUP;
    }

    /**
     * 判断是否特殊座位
     */
    public boolean isSpecial() {
        return this != NORMAL;
    }
}