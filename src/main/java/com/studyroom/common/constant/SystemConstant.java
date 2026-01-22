package com.studyroom.common.constant;

/**
 * 系统相关常量
 */
public class SystemConstant {

    // 系统版本
    public static final String SYSTEM_VERSION = "1.0.0";
    public static final String SYSTEM_NAME = "高校自习室预约平台";
    public static final String SYSTEM_DESCRIPTION = "高校自习室预约管理系统";

    // 默认配置
    public static final String DEFAULT_TIMEZONE = "Asia/Shanghai";
    public static final String DEFAULT_LANGUAGE = "zh-CN";
    public static final String DEFAULT_CHARSET = "UTF-8";

    // 文件上传配置
    public static final long MAX_FILE_SIZE = 10 * 1024 * 1024;  // 10MB
    public static final long MAX_REQUEST_SIZE = 50 * 1024 * 1024; // 50MB
    public static final String[] ALLOWED_IMAGE_TYPES = {
            "image/jpeg", "image/png", "image/gif", "image/bmp"
    };
    public static final String[] ALLOWED_EXCEL_TYPES = {
            "application/vnd.ms-excel",
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
    };

    // 路径配置
    public static final String UPLOAD_DIR = "uploads";
    public static final String STATIC_DIR = "static";
    public static final String TEMPLATE_DIR = "templates";
    public static final String LOG_DIR = "logs";

    // 缓存配置
    public static final String CACHE_NAME_USER = "userCache";
    public static final String CACHE_NAME_ROOM = "roomCache";
    public static final String CACHE_NAME_RESERVATION = "reservationCache";
    public static final String CACHE_NAME_CONFIG = "configCache";

    // 系统参数配置键
    public static final String CONFIG_KEY_SYSTEM_NAME = "system.name";
    public static final String CONFIG_KEY_SYSTEM_VERSION = "system.version";
    public static final String CONFIG_KEY_RESERVATION_RULES = "reservation.rules";
    public static final String CONFIG_KEY_VIOLATION_RULES = "violation.rules";
    public static final String CONFIG_KEY_SYSTEM_MAINTENANCE = "system.maintenance";
    public static final String CONFIG_KEY_EMAIL_CONFIG = "email.config";
    public static final String CONFIG_KEY_SMS_CONFIG = "sms.config";

    // 时间格式
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String TIMESTAMP_FORMAT = "yyyyMMddHHmmssSSS";

    // 响应头常量
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String HEADER_X_REQUESTED_WITH = "X-Requested-With";
    public static final String HEADER_X_FORWARDED_FOR = "X-Forwarded-For";

    // 内容类型
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    public static final String CONTENT_TYPE_MULTIPART = "multipart/form-data";
    public static final String CONTENT_TYPE_XML = "application/xml";
    public static final String CONTENT_TYPE_HTML = "text/html";

    // 加密相关
    public static final String ENCRYPTION_ALGORITHM = "MD5";
    public static final String ENCRYPTION_SALT = "study-room-2023";
    public static final int ENCRYPTION_ITERATIONS = 3;

    // 验证码配置
    public static final int CAPTCHA_WIDTH = 120;
    public static final int CAPTCHA_HEIGHT = 40;
    public static final int CAPTCHA_LENGTH = 4;
    public static final long CAPTCHA_EXPIRE_SECONDS = 300;  // 5分钟

    // 分页配置
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int MAX_PAGE_SIZE = 100;
    public static final String DEFAULT_SORT_FIELD = "create_time";
    public static final String DEFAULT_SORT_ORDER = "desc";

    // 日志相关
    public static final String LOG_TYPE_OPERATION = "operation";
    public static final String LOG_TYPE_LOGIN = "login";
    public static final String LOG_TYPE_ERROR = "error";
    public static final String LOG_TYPE_SYSTEM = "system";

    // 通知类型
    public static final String NOTIFICATION_TYPE_SYSTEM = "system";
    public static final String NOTIFICATION_TYPE_RESERVATION = "reservation";
    public static final String NOTIFICATION_TYPE_VIOLATION = "violation";
    public static final String NOTIFICATION_TYPE_ANNOUNCEMENT = "announcement";
    public static final String NOTIFICATION_TYPE_REMINDER = "reminder";

    // 系统状态
    public static final int SYSTEM_STATUS_NORMAL = 1;      // 正常
    public static final int SYSTEM_STATUS_MAINTENANCE = 2; // 维护中
    public static final int SYSTEM_STATUS_UPGRADE = 3;     // 升级中
    public static final int SYSTEM_STATUS_ERROR = 4;       // 异常
}