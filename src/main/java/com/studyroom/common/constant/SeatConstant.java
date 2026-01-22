package com.studyroom.common.constant;

/**
 * 座位相关常量
 */
public class SeatConstant {

    // 座位状态枚举值（与数据库对应）
    public static final Integer SEAT_STATUS_AVAILABLE_CODE = 1;
    public static final Integer SEAT_STATUS_RESERVED_CODE = 2;
    public static final Integer SEAT_STATUS_IN_USE_CODE = 3;
    public static final Integer SEAT_STATUS_MAINTENANCE_CODE = 4;
    public static final Integer SEAT_STATUS_UNAVAILABLE_CODE = 5;

    // 座位类型枚举值
    public static final Integer SEAT_TYPE_NORMAL_CODE = 1;
    public static final Integer SEAT_TYPE_VIP_CODE = 2;
    public static final Integer SEAT_TYPE_DISABLED_CODE = 3;
    public static final Integer SEAT_TYPE_STANDING_CODE = 4;

    // 座位位置配置
    public static final Integer DEFAULT_SEAT_WIDTH = 80;    // 座位宽度（像素）
    public static final Integer DEFAULT_SEAT_HEIGHT = 80;   // 座位高度（像素）
    public static final Integer DEFAULT_SEAT_MARGIN = 10;   // 座位间距（像素）

    // 座位颜色配置（用于前端显示）
    public static final String COLOR_AVAILABLE = "#52c41a";    // 可用 - 绿色
    public static final String COLOR_RESERVED = "#faad14";     // 已预约 - 黄色
    public static final String COLOR_IN_USE = "#1890ff";       // 使用中 - 蓝色
    public static final String COLOR_TEMP_LEAVE = "#722ed1";   // 暂离 - 紫色
    public static final String COLOR_MAINTENANCE = "#f5222d";  // 维护中 - 红色
    public static final String COLOR_UNAVAILABLE = "#8c8c8c";  // 不可用 - 灰色

    // WebSocket消息类型
    public static final String WS_SEAT_STATUS_UPDATE = "seat_status_update";
    public static final String WS_SEAT_BATCH_UPDATE = "seat_batch_update";
    public static final String WS_ROOM_STATUS_UPDATE = "room_status_update";

    // 缓存相关
    public static final String CACHE_SEAT_STATUS_PREFIX = "seat:status:";
    public static final Long CACHE_SEAT_STATUS_TTL = 300L;  // 5分钟

    // 座位统计相关
    public static final String STATS_SEAT_USAGE_PREFIX = "stats:seat:usage:";
    public static final String STATS_SEAT_HEATMAP_PREFIX = "stats:seat:heatmap:";
}