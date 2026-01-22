package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 签到方式枚举
 */
@Getter
public enum CheckInMethodEnum implements StringBaseEnum{

    QRCODE("qrcode", "二维码签到", "扫描二维码签到"),
    FACE("face", "人脸识别", "人脸识别签到"),
    MANUAL("manual", "手动签到", "管理员手动签到"),
    SYSTEM("system", "系统自动", "系统自动签到"),
    ADMIN("admin", "管理员操作", "管理员操作签到"),
    CARD("card", "刷卡签到", "校园卡刷卡签到");

    private final String code;
    private final String name;
    private final String description;

    CheckInMethodEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static CheckInMethodEnum getByCode(String code) {
        for (CheckInMethodEnum method : values()) {
            if (method.getCode().equals(code)) {
                return method;
            }
        }
        return null;
    }

    /**
     * 获取学生可用的签到方式
     */
    public static CheckInMethodEnum[] getStudentMethods() {
        return new CheckInMethodEnum[]{QRCODE, FACE, CARD};
    }

    /**
     * 获取管理员可用的签到方式
     */
    public static CheckInMethodEnum[] getAdminMethods() {
        return new CheckInMethodEnum[]{MANUAL, ADMIN, SYSTEM};
    }

    /**
     * 判断是否为自动签到
     */
    public boolean isAuto() {
        return this == SYSTEM;
    }

    /**
     * 判断是否需要验证
     */
    public boolean requiresVerification() {
        return this == QRCODE || this == FACE || this == CARD;
    }
}