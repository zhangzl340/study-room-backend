package com.studyroom.common.constant;

/**
 * 违规相关常量
 */
public class ViolationConstant {

    // 违规类型
    public static final String VIOLATION_TYPE_NO_SHOW = "no_show";              // 爽约
    public static final String VIOLATION_TYPE_LATE_CHECKIN = "late_checkin";    // 迟到
    public static final String VIOLATION_TYPE_EARLY_CHECKOUT = "early_checkout"; // 提前离开
    public static final String VIOLATION_TYPE_OVERSTAY = "overstay";            // 超时占用
    public static final String VIOLATION_TYPE_NO_CHECKOUT = "no_checkout";      // 未签退
    public static final String VIOLATION_TYPE_FAKE_CHECKIN = "fake_checkin";    // 虚假签到
    public static final String VIOLATION_TYPE_OTHER = "other";                  // 其他

    // 违规等级
    public static final String VIOLATION_LEVEL_MINOR = "minor";     // 轻微
    public static final String VIOLATION_LEVEL_MEDIUM = "medium";   // 中等
    public static final String VIOLATION_LEVEL_MAJOR = "major";     // 严重
    public static final String VIOLATION_LEVEL_SERIOUS = "serious"; // 非常严重

    // 违规处理状态
    public static final String VIOLATION_STATUS_PENDING = "pending";      // 待处理
    public static final String VIOLATION_STATUS_PROCESSED = "processed";  // 已处理
    public static final String VIOLATION_STATUS_APPEALING = "appealing";  // 申诉中
    public static final String VIOLATION_STATUS_APPEALED = "appealed";    // 已申诉
    public static final String VIOLATION_STATUS_CANCELLED = "cancelled";  // 已撤销

    // 违规扣分规则
    public static final Integer DEDUCTION_NO_SHOW = 10;           // 爽约扣分
    public static final Integer DEDUCTION_LATE_CHECKIN = 5;       // 迟到扣分
    public static final Integer DEDUCTION_EARLY_CHECKOUT = 3;     // 提前离开扣分
    public static final Integer DEDUCTION_OVERSTAY = 8;           // 超时占用扣分
    public static final Integer DEDUCTION_NO_CHECKOUT = 8;        // 未签退扣分
    public static final Integer DEDUCTION_FAKE_CHECKIN = 15;      // 虚假签到扣分

    // 申诉相关
    public static final Integer APPEAL_EXPIRE_DAYS = 7;           // 申诉有效期（天）
    public static final String APPEAL_RESULT_ACCEPTED = "accepted";   // 申诉通过
    public static final String APPEAL_RESULT_REJECTED = "rejected";   // 申诉驳回

    // 自动检测设置
    public static final Integer AUTO_DETECT_NO_SHOW_MINUTES = 15; // 爽约检测时间（签到时间后）
    public static final Integer AUTO_DETECT_NO_CHECKOUT_HOURS = 24; // 未签退检测时间

    // 缓存相关
    public static final String CACHE_VIOLATION_PREFIX = "violation:";
    public static final String CACHE_USER_VIOLATION_COUNT_PREFIX = "user:violation:count:";
    public static final Long CACHE_VIOLATION_TTL = 86400L;  // 24小时
}