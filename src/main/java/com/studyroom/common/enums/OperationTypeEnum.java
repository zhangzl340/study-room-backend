package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 操作类型枚举
 */
@Getter
public enum OperationTypeEnum implements StringBaseEnum{

    // 用户操作
    LOGIN("login", "用户登录", "用户登录系统"),
    LOGOUT("logout", "用户登出", "用户退出系统"),
    REGISTER("register", "用户注册", "用户注册账号"),
    UPDATE_PROFILE("update_profile", "更新资料", "更新个人资料"),
    CHANGE_PASSWORD("change_password", "修改密码", "修改登录密码"),

    // 预约操作
    CREATE_RESERVATION("create_reservation", "创建预约", "创建新的预约"),
    CANCEL_RESERVATION("cancel_reservation", "取消预约", "取消已有的预约"),
    UPDATE_RESERVATION("update_reservation", "修改预约", "修改预约信息"),

    // 签到操作
    CHECK_IN("check_in", "签到", "用户签到"),
    CHECK_OUT("check_out", "签退", "用户签退"),
    TEMP_LEAVE("temp_leave", "暂离", "用户暂时离开"),
    RETURN_SEAT("return_seat", "返回", "用户返回座位"),

    // 管理操作
    CREATE_USER("create_user", "创建用户", "管理员创建用户"),
    UPDATE_USER("update_user", "更新用户", "管理员更新用户信息"),
    DELETE_USER("delete_user", "删除用户", "管理员删除用户"),
    ADJUST_CREDIT("adjust_credit", "调整信用分", "管理员调整用户信用分"),

    // 系统操作
    UPDATE_SETTINGS("update_settings", "更新设置", "更新系统设置"),
    CREATE_ANNOUNCEMENT("create_announcement", "创建公告", "创建系统公告"),
    UPDATE_ANNOUNCEMENT("update_announcement", "更新公告", "更新系统公告"),
    DELETE_ANNOUNCEMENT("delete_announcement", "删除公告", "删除系统公告"),

    // 数据操作
    IMPORT_DATA("import_data", "导入数据", "导入系统数据"),
    EXPORT_DATA("export_data", "导出数据", "导出系统数据"),
    CLEANUP_DATA("cleanup_data", "清理数据", "清理过期数据");

    private final String code;
    private final String name;
    private final String description;

    OperationTypeEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static OperationTypeEnum getByCode(String code) {
        for (OperationTypeEnum type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

    /**
     * 判断是否为敏感操作
     */
    public boolean isSensitive() {
        return switch (this) {
            case CHANGE_PASSWORD, DELETE_USER, ADJUST_CREDIT, UPDATE_SETTINGS -> true;
            default -> false;
        };
    }

    /**
     * 判断是否需要记录详细日志
     */
    public boolean requiresDetailLog() {
        return isSensitive() || this == CREATE_RESERVATION || this == CANCEL_RESERVATION;
    }
}