package com.studyroom.common.constant;

import java.util.Arrays;
import java.util.List;

/**
 * 权限相关常量
 */
public class PermissionConstant {

    // 权限前缀
    public static final String PERMISSION_PREFIX = "study-room:";

    // 学生权限
    public static class Student {
        public static final String RESERVATION_CREATE = PERMISSION_PREFIX + "student:reservation:create";
        public static final String RESERVATION_VIEW = PERMISSION_PREFIX + "student:reservation:view";
        public static final String RESERVATION_CANCEL = PERMISSION_PREFIX + "student:reservation:cancel";
        public static final String CHECKIN = PERMISSION_PREFIX + "student:checkin";
        public static final String CHECKOUT = PERMISSION_PREFIX + "student:checkout";
        public static final String TEMP_LEAVE = PERMISSION_PREFIX + "student:temp:leave";
        public static final String PROFILE_VIEW = PERMISSION_PREFIX + "student:profile:view";
        public static final String PROFILE_UPDATE = PERMISSION_PREFIX + "student:profile:update";
        public static final String ROOM_VIEW = PERMISSION_PREFIX + "student:room:view";
        public static final String SEAT_VIEW = PERMISSION_PREFIX + "student:seat:view";

        public static List<String> getAllPermissions() {
            return Arrays.asList(
                    RESERVATION_CREATE, RESERVATION_VIEW, RESERVATION_CANCEL,
                    CHECKIN, CHECKOUT, TEMP_LEAVE,
                    PROFILE_VIEW, PROFILE_UPDATE,
                    ROOM_VIEW, SEAT_VIEW
            );
        }
    }

    // 管理员权限
    public static class Admin {
        // 用户管理
        public static final String USER_VIEW = PERMISSION_PREFIX + "admin:user:view";
        public static final String USER_CREATE = PERMISSION_PREFIX + "admin:user:create";
        public static final String USER_UPDATE = PERMISSION_PREFIX + "admin:user:update";
        public static final String USER_DELETE = PERMISSION_PREFIX + "admin:user:delete";
        public static final String USER_IMPORT = PERMISSION_PREFIX + "admin:user:import";
        public static final String USER_EXPORT = PERMISSION_PREFIX + "admin:user:export";

        // 自习室管理
        public static final String ROOM_VIEW = PERMISSION_PREFIX + "admin:room:view";
        public static final String ROOM_CREATE = PERMISSION_PREFIX + "admin:room:create";
        public static final String ROOM_UPDATE = PERMISSION_PREFIX + "admin:room:update";
        public static final String ROOM_DELETE = PERMISSION_PREFIX + "admin:room:delete";
        public static final String SEAT_MANAGE = PERMISSION_PREFIX + "admin:seat:manage";
        public static final String LAYOUT_EDIT = PERMISSION_PREFIX + "admin:layout:edit";

        // 预约管理
        public static final String RESERVATION_VIEW_ALL = PERMISSION_PREFIX + "admin:reservation:view:all";
        public static final String RESERVATION_CANCEL_ANY = PERMISSION_PREFIX + "admin:reservation:cancel:any";
        public static final String RESERVATION_FORCE_CHECKOUT = PERMISSION_PREFIX + "admin:reservation:force:checkout";

        // 系统设置
        public static final String SETTINGS_VIEW = PERMISSION_PREFIX + "admin:settings:view";
        public static final String SETTINGS_UPDATE = PERMISSION_PREFIX + "admin:settings:update";
        public static final String RULES_MANAGE = PERMISSION_PREFIX + "admin:rules:manage";
        public static final String ANNOUNCEMENT_MANAGE = PERMISSION_PREFIX + "admin:announcement:manage";

        // 数据统计
        public static final String STATS_VIEW = PERMISSION_PREFIX + "admin:stats:view";
        public static final String STATS_EXPORT = PERMISSION_PREFIX + "admin:stats:export";

        // 日志管理
        public static final String LOGS_VIEW = PERMISSION_PREFIX + "admin:logs:view";

        // 违规处理
        public static final String VIOLATION_VIEW = PERMISSION_PREFIX + "admin:violation:view";
        public static final String VIOLATION_HANDLE = PERMISSION_PREFIX + "admin:violation:handle";
        public static final String CREDIT_ADJUST = PERMISSION_PREFIX + "admin:credit:adjust";

        public static List<String> getAllPermissions() {
            return Arrays.asList(
                    USER_VIEW, USER_CREATE, USER_UPDATE, USER_DELETE, USER_IMPORT, USER_EXPORT,
                    ROOM_VIEW, ROOM_CREATE, ROOM_UPDATE, ROOM_DELETE, SEAT_MANAGE, LAYOUT_EDIT,
                    RESERVATION_VIEW_ALL, RESERVATION_CANCEL_ANY, RESERVATION_FORCE_CHECKOUT,
                    SETTINGS_VIEW, SETTINGS_UPDATE, RULES_MANAGE, ANNOUNCEMENT_MANAGE,
                    STATS_VIEW, STATS_EXPORT, LOGS_VIEW,
                    VIOLATION_VIEW, VIOLATION_HANDLE, CREDIT_ADJUST
            );
        }
    }

    // 超级管理员权限
    public static class SuperAdmin {
        public static final String ALL_PERMISSIONS = PERMISSION_PREFIX + "*";
        public static final String ADMIN_MANAGE = PERMISSION_PREFIX + "admin:manage";
        public static final String PERMISSION_MANAGE = PERMISSION_PREFIX + "permission:manage";
        public static final String ROLE_MANAGE = PERMISSION_PREFIX + "role:manage";
        public static final String DATA_CLEANUP = PERMISSION_PREFIX + "data:cleanup";
        public static final String SYSTEM_BACKUP = PERMISSION_PREFIX + "system:backup";

        public static List<String> getAllPermissions() {
            List<String> permissions = Admin.getAllPermissions();
            permissions.addAll(Arrays.asList(
                    ALL_PERMISSIONS, ADMIN_MANAGE, PERMISSION_MANAGE,
                    ROLE_MANAGE, DATA_CLEANUP, SYSTEM_BACKUP
            ));
            return permissions;
        }
    }

    // 权限组
    public static class PermissionGroup {
        public static final String USER_MANAGEMENT = "用户管理";
        public static final String ROOM_MANAGEMENT = "自习室管理";
        public static final String RESERVATION_MANAGEMENT = "预约管理";
        public static final String SYSTEM_MANAGEMENT = "系统管理";
        public static final String STATISTICS_MANAGEMENT = "数据统计";
        public static final String SECURITY_MANAGEMENT = "安全管理";
    }
}