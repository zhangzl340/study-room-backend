package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 违规类型枚举
 */
@Getter
public enum ViolationTypeEnum implements StringBaseEnum{

    NO_SHOW("no_show", "爽约", "预约后未按时签到", 10, "major"),
    LATE_CHECKIN("late_checkin", "迟到", "超过规定时间签到", 5, "medium"),
    EARLY_CHECKOUT("early_checkout", "提前离开", "未到时间提前签退", 3, "minor"),
    OVERSTAY("overstay", "超时占用", "超过预约时间未签退", 8, "medium"),
    NO_CHECKOUT("no_checkout", "未签退", "使用后未进行签退", 8, "medium"),
    FAKE_CHECKIN("fake_checkin", "虚假签到", "使用不正当手段签到", 15, "serious"),
    OTHER("other", "其他违规", "其他类型的违规行为", 5, "minor");

    private final String code;
    private final String name;
    private final String description;
    private final Integer deduction;  // 扣分
    private final String level;       // 违规等级

    ViolationTypeEnum(String code, String name, String description, Integer deduction, String level) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.deduction = deduction;
        this.level = level;
    }

    /**
     * 根据code获取枚举
     */
    public static ViolationTypeEnum getByCode(String code) {
        for (ViolationTypeEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return OTHER;
    }

    /**
     * 获取扣分数值
     */
    public static Integer getDeductionByCode(String code) {
        ViolationTypeEnum type = getByCode(code);
        return type != null ? type.getDeduction() : 5;
    }

    /**
     * 判断是否为严重违规
     */
    public boolean isSerious() {
        return "serious".equals(this.level) || "major".equals(this.level);
    }

    /**
     * 判断是否为中等违规
     */
    public boolean isMedium() {
        return "medium".equals(this.level);
    }

    /**
     * 判断是否为轻微违规
     */
    public boolean isMinor() {
        return "minor".equals(this.level);
    }

    /**
     * 获取违规等级的中文描述
     */
    public String getLevelName() {
        return switch (this.level) {
            case "minor" -> "轻微";
            case "medium" -> "中等";
            case "major" -> "严重";
            case "serious" -> "非常严重";
            default -> "未知";
        };
    }
}