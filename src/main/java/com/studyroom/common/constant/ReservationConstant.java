package com.studyroom.common.constant;

/**
 * 预约相关常量
 */
public class ReservationConstant {

    // 预约状态
    public static final String RESERVATION_STATUS_PENDING = "pending";            // 待确认
    public static final String RESERVATION_STATUS_CONFIRMED = "confirmed";        // 已确认
    public static final String RESERVATION_STATUS_CHECKED_IN = "checked_in";      // 已签到
    public static final String RESERVATION_STATUS_IN_USE = "in_use";              // 使用中
    public static final String RESERVATION_STATUS_TEMPORARY_LEAVE = "temporary_leave"; // 暂离
    public static final String RESERVATION_STATUS_COMPLETED = "completed";        // 已完成
    public static final String RESERVATION_STATUS_CANCELLED = "cancelled";        // 已取消
    public static final String RESERVATION_STATUS_NO_SHOW = "no_show";            // 爽约
    public static final String RESERVATION_STATUS_EXPIRED = "expired";            // 已过期

    // 预约类型
    public static final String RESERVATION_TYPE_NORMAL = "normal";        // 普通预约
    public static final String RESERVATION_TYPE_IMMEDIATE = "immediate";  // 即时预约
    public static final String RESERVATION_TYPE_RECURRING = "recurring";  // 重复预约

    // 签到方式
    public static final String CHECKIN_METHOD_QRCODE = "qrcode";  // 二维码签到
    public static final String CHECKIN_METHOD_FACE = "face";      // 人脸识别签到
    public static final String CHECKIN_METHOD_MANUAL = "manual";  // 手动签到
    public static final String CHECKIN_METHOD_SYSTEM = "system";  // 系统自动签到
    public static final String CHECKIN_METHOD_ADMIN = "admin";    // 管理员签到

    // 默认时间设置（分钟）
    public static final Integer CHECKIN_EARLY_MINUTES = 15;       // 可提前签到时间
    public static final Integer CHECKIN_LATE_MINUTES = 30;        // 可迟到签到时间
    public static final Integer AUTO_CANCEL_MINUTES = 15;         // 自动取消时间（签到时间后）
    public static final Integer TEMP_LEAVE_MAX_MINUTES = 15;      // 最大暂离时间
    public static final Integer DEFAULT_CANCEL_DEADLINE = 30;     // 取消截止时间（签到前）

    // 缓存相关
    public static final String CACHE_RESERVATION_PREFIX = "reservation:";
    public static final String CACHE_RESERVATION_CONFLICT_PREFIX = "reservation:conflict:";
    public static final String CACHE_RESERVATION_AVAILABILITY_PREFIX = "reservation:availability:";
    public static final Long CACHE_RESERVATION_TTL = 300L;  // 5分钟

    // 分布式锁
    public static final String LOCK_RESERVATION_CREATE = "lock:reservation:create:";
    public static final String LOCK_RESERVATION_CANCEL = "lock:reservation:cancel:";
    public static final Long LOCK_RESERVATION_TIMEOUT = 10L;  // 10秒

    // 预约冲突检测
    public static final String CONFLICT_TYPE_TIME_OVERLAP = "time_overlap";      // 时间重叠
    public static final String CONFLICT_TYPE_SAME_SEAT = "same_seat";           // 同一座位
    public static final String CONFLICT_TYPE_SAME_USER = "same_user";           // 同一用户
    public static final String CONFLICT_TYPE_ROOM_CLOSED = "room_closed";       // 自习室关闭
    public static final String CONFLICT_TYPE_SEAT_UNAVAILABLE = "seat_unavailable"; // 座位不可用
}