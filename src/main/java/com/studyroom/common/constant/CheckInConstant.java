package com.studyroom.common.constant;

/**
 * 签到相关常量
 */
public class CheckInConstant {

    // 签到操作类型
    public static final String CHECKIN_ACTION_CHECKIN = "check_in";         // 签到
    public static final String CHECKIN_ACTION_CHECKOUT = "check_out";       // 签退
    public static final String CHECKIN_ACTION_TEMP_LEAVE = "temporary_leave"; // 暂离
    public static final String CHECKIN_ACTION_RETURN = "return";            // 返回
    public static final String CHECKIN_ACTION_FORCE_CHECKOUT = "force_checkout"; // 强制签退

    // 签到状态
    public static final Integer CHECKIN_STATUS_NORMAL = 1;      // 正常
    public static final Integer CHECKIN_STATUS_LATE = 2;        // 迟到
    public static final Integer CHECKIN_STATUS_EARLY = 3;       // 提前
    public static final Integer CHECKIN_STATUS_ABSENT = 4;      // 缺勤

    // 二维码配置
    public static final Integer QRCODE_WIDTH = 300;
    public static final Integer QRCODE_HEIGHT = 300;
    public static final String QRCODE_FORMAT = "png";
    public static final String QRCODE_CHARSET = "UTF-8";
    public static final Long QRCODE_EXPIRE_MINUTES = 5L;  // 二维码有效期5分钟

    // 人脸识别配置
    public static final Double FACE_MATCH_THRESHOLD = 0.8;  // 人脸匹配阈值
    public static final Integer FACE_IMAGE_WIDTH = 640;     // 人脸图片宽度
    public static final Integer FACE_IMAGE_HEIGHT = 480;    // 人脸图片高度

    // 签到时间限制（单位：分钟）
    public static final Integer CHECKIN_ALLOW_EARLY = 15;   // 允许提前签到
    public static final Integer CHECKIN_ALLOW_LATE = 30;    // 允许迟到签到
    public static final Integer CHECKOUT_ALLOW_EARLY = 5;   // 允许提前签退
    public static final Integer CHECKOUT_ALLOW_LATE = 10;   // 允许延迟签退

    // 暂离设置
    public static final Integer TEMP_LEAVE_MAX_MINUTES = 15;  // 最大暂离时间
    public static final Integer TEMP_LEAVE_WARNING_MINUTES = 5; // 暂离警告时间

    // 缓存相关
    public static final String CACHE_QRCODE_PREFIX = "qrcode:";
    public static final Long CACHE_QRCODE_TTL = 300L;  // 5分钟
    public static final String CACHE_CHECKIN_SESSION_PREFIX = "checkin:session:";
    public static final Long CACHE_CHECKIN_SESSION_TTL = 1800L;  // 30分钟

    // 签到设备类型
    public static final String DEVICE_TYPE_MOBILE = "mobile";      // 手机
    public static final String DEVICE_TYPE_PC = "pc";              // 电脑
    public static final String DEVICE_TYPE_TABLET = "tablet";      // 平板
    public static final String DEVICE_TYPE_KIOSK = "kiosk";        // 自助机
}