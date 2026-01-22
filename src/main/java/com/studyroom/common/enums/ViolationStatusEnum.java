package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 违规处理状态枚举
 */
@Getter
public enum ViolationStatusEnum implements StringBaseEnum{

    PENDING("pending", "待处理", "违规记录待处理"),
    PROCESSED("processed", "已处理", "违规记录已处理"),
    APPEALING("appealing", "申诉中", "用户已提交申诉"),
    APPEALED("appealed", "已申诉", "申诉已处理"),
    CANCELLED("cancelled", "已撤销", "违规记录已撤销");

    private final String code;
    private final String name;
    private final String description;

    ViolationStatusEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static ViolationStatusEnum getByCode(String code) {
        for (ViolationStatusEnum status : values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }

    /**
     * 判断是否可申诉
     */
    public boolean canAppeal() {
        return this == PROCESSED;
    }

    /**
     * 判断是否在处理中
     */
    public boolean isProcessing() {
        return this == PENDING || this == APPEALING;
    }

    /**
     * 判断是否已完结
     */
    public boolean isFinished() {
        return this == APPEALED || this == CANCELLED;
    }
}