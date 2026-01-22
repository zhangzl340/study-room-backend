package com.studyroom.common.constant;

/**
 * Redis Key常量
 */
public class RedisKeyConstant {

    // 分隔符
    public static final String KEY_SEPARATOR = ":";

    // 用户相关
    public static final String USER_TOKEN_KEY = "user:token:";                  // 用户token:userId
    public static final String USER_INFO_KEY = "user:info:";                    // 用户信息:userId
    public static final String USER_SESSION_KEY = "user:session:";              // 用户会话:sessionId
    public static final String USER_LOGIN_ATTEMPTS_KEY = "user:login:attempts:"; // 登录尝试:username
    public static final String USER_ONLINE_KEY = "user:online:";               // 在线用户:userId
    public static final String USER_CREDIT_KEY = "user:credit:";               // 用户信用分:userId

    // 自习室相关
    public static final String ROOM_LIST_KEY = "room:list";                     // 自习室列表
    public static final String ROOM_DETAIL_KEY = "room:detail:";                // 自习室详情:roomId
    public static final String ROOM_SEATS_KEY = "room:seats:";                  // 自习室座位:roomId
    public static final String ROOM_STATUS_KEY = "room:status:";                // 自习室状态:roomId

    // 座位相关
    public static final String SEAT_STATUS_KEY = "seat:status:";                // 座位状态:seatId
    public static final String SEAT_RESERVATION_KEY = "seat:reservation:";      // 座位预约:seatId
    public static final String SEAT_AVAILABILITY_KEY = "seat:availability:";    // 座位可用性:seatId:date

    // 预约相关
    public static final String RESERVATION_DETAIL_KEY = "reservation:detail:";  // 预约详情:reservationId
    public static final String RESERVATION_USER_KEY = "reservation:user:";      // 用户预约:userId
    public static final String RESERVATION_CONFLICT_KEY = "reservation:conflict:"; // 预约冲突检测
    public static final String RESERVATION_LOCK_KEY = "reservation:lock:";      // 预约分布式锁:key

    // 签到相关
    public static final String CHECKIN_QRCODE_KEY = "checkin:qrcode:";          // 签到二维码:reservationId
    public static final String CHECKIN_SESSION_KEY = "checkin:session:";        // 签到会话:sessionId
    public static final String CHECKIN_RECORD_KEY = "checkin:record:";          // 签到记录:reservationId

    // 统计相关
    public static final String STATS_USAGE_KEY = "stats:usage:";                // 使用统计:roomId:date
    public static final String STATS_HEATMAP_KEY = "stats:heatmap:";            // 热度图:roomId:date
    public static final String STATS_USER_ACTIVITY_KEY = "stats:user:activity:"; // 用户活跃度:date
    public static final String STATS_VIOLATION_KEY = "stats:violation:";        // 违规统计:date

    // 系统相关
    public static final String SYSTEM_CONFIG_KEY = "system:config:";            // 系统配置:configKey
    public static final String ANNOUNCEMENT_KEY = "announcement:";              // 公告:announcementId
    public static final String CAPTCHA_KEY = "captcha:";                        // 验证码:captchaId
    public static final String RATE_LIMIT_KEY = "rate:limit:";                  // 限流:key

    // 锁相关
    public static final String LOCK_PREFIX = "lock:";                           // 分布式锁前缀
    public static final String LOCK_SEAT_RESERVATION = "lock:seat:reservation:"; // 座位预约锁:seatId
    public static final String LOCK_USER_RESERVATION = "lock:user:reservation:"; // 用户预约锁:userId
    public static final String LOCK_ROOM_UPDATE = "lock:room:update:";          // 自习室更新锁:roomId

    // 队列相关
    public static final String QUEUE_RESERVATION_CREATE = "queue:reservation:create"; // 预约创建队列
    public static final String QUEUE_RESERVATION_CANCEL = "queue:reservation:cancel"; // 预约取消队列
    public static final String QUEUE_CHECKIN_PROCESS = "queue:checkin:process";       // 签到处理队列

    // 过期时间（秒）
    public static final Long EXPIRE_5_MINUTES = 300L;         // 5分钟
    public static final Long EXPIRE_15_MINUTES = 900L;        // 15分钟
    public static final Long EXPIRE_30_MINUTES = 1800L;       // 30分钟
    public static final Long EXPIRE_1_HOUR = 3600L;           // 1小时
    public static final Long EXPIRE_2_HOURS = 7200L;          // 2小时
    public static final Long EXPIRE_6_HOURS = 21600L;         // 6小时
    public static final Long EXPIRE_12_HOURS = 43200L;        // 12小时
    public static final Long EXPIRE_1_DAY = 86400L;           // 1天
    public static final Long EXPIRE_7_DAYS = 604800L;         // 7天
    public static final Long EXPIRE_30_DAYS = 2592000L;       // 30天

    // 模式匹配
    public static final String PATTERN_ALL_KEYS = "*";
    public static final String PATTERN_USER_TOKENS = "user:token:*";
    public static final String PATTERN_ROOM_STATUS = "room:status:*";
    public static final String PATTERN_SEAT_STATUS = "seat:status:*";
    public static final String PATTERN_RESERVATION_LOCKS = "reservation:lock:*";
}