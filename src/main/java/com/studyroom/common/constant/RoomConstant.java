package com.studyroom.common.constant;

/**
 * 自习室相关常量
 */
public class RoomConstant {

    // 自习室状态
    public static final Integer ROOM_STATUS_CLOSED = 0;      // 关闭
    public static final Integer ROOM_STATUS_OPEN = 1;        // 开放
    public static final Integer ROOM_STATUS_MAINTENANCE = 2; // 维护中

    // 座位状态
    public static final String SEAT_STATUS_AVAILABLE = "available";       // 可用
    public static final String SEAT_STATUS_RESERVED = "reserved";         // 已预约
    public static final String SEAT_STATUS_IN_USE = "in_use";             // 使用中
    public static final String SEAT_STATUS_MAINTENANCE = "maintenance";   // 维护中
    public static final String SEAT_STATUS_UNAVAILABLE = "unavailable";   // 不可用

    // 座位类型
    public static final String SEAT_TYPE_NORMAL = "normal";     // 普通座位
    public static final String SEAT_TYPE_VIP = "vip";           // VIP座位
    public static final String SEAT_TYPE_DISABLED = "disabled"; // 无障碍座位
    public static final String SEAT_TYPE_STANDING = "standing"; // 站立座位

    // 预约规则默认值
    public static final Integer DEFAULT_MAX_RESERVATION_MINUTES = 240;    // 4小时
    public static final Integer DEFAULT_MIN_RESERVATION_MINUTES = 30;     // 30分钟
    public static final Integer DEFAULT_ADVANCE_RESERVATION_HOURS = 24;   // 24小时

    // 自习室设施
    public static final String FACILITY_POWER = "power";          // 电源
    public static final String FACILITY_WIFI = "wifi";            // WiFi
    public static final String FACILITY_AIR_CONDITIONER = "air_conditioner"; // 空调
    public static final String FACILITY_WATER = "water";          // 饮水机
    public static final String FACILITY_PRINTER = "printer";      // 打印机
    public static final String FACILITY_SCANNER = "scanner";      // 扫描仪

    // 座位特性
    public static final String SEAT_FEATURE_WINDOW = "window";    // 靠窗
    public static final String SEAT_FEATURE_QUIET = "quiet";      // 静音区
    public static final String SEAT_FEATURE_LAMP = "lamp";        // 台灯
    public static final String SEAT_FEATURE_OUTLET = "outlet";    // 插座

    // 缓存相关
    public static final String CACHE_ROOM_LIST = "room:list";
    public static final String CACHE_ROOM_DETAIL_PREFIX = "room:detail:";
    public static final String CACHE_ROOM_SEATS_PREFIX = "room:seats:";
    public static final String CACHE_ROOM_STATUS_PREFIX = "room:status:";
    public static final Long CACHE_ROOM_TTL = 1800L;  // 30分钟

    // 座位布局
    public static final Integer DEFAULT_ROWS = 10;
    public static final Integer DEFAULT_COLS = 10;
    public static final String DEFAULT_LAYOUT_TYPE = "grid";  // 网格布局
}