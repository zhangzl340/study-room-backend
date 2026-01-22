/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80300
 Source Host           : localhost:3308
 Source Schema         : study_room_db

 Target Server Type    : MySQL
 Target Server Version : 80300
 File Encoding         : 65001

 Date: 22/01/2026 18:03:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement`  (
                                 `id` bigint NOT NULL AUTO_INCREMENT COMMENT '公告ID',
                                 `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '公告标题',
                                 `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '公告内容',
                                 `announcement_type` enum('system','activity','maintenance','notice','other') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'notice' COMMENT '公告类型',
                                 `priority` tinyint(1) NOT NULL DEFAULT 0 COMMENT '优先级（0-5，5最高）',
                                 `publisher_id` bigint NOT NULL COMMENT '发布人ID',
                                 `publish_time` datetime NOT NULL COMMENT '发布时间',
                                 `start_time` datetime NULL DEFAULT NULL COMMENT '生效开始时间',
                                 `end_time` datetime NULL DEFAULT NULL COMMENT '生效结束时间',
                                 `status` enum('draft','published','expired','withdrawn') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'draft' COMMENT '状态',
                                 `view_count` int NULL DEFAULT 0 COMMENT '查看次数',
                                 `target_roles` json NULL COMMENT '目标角色（JSON数组）',
                                 `target_colleges` json NULL COMMENT '目标学院（JSON数组）',
                                 `is_all_users` tinyint(1) NULL DEFAULT 1 COMMENT '是否所有用户',
                                 `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                 `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                 `deleted` tinyint(1) NULL DEFAULT 0,
                                 PRIMARY KEY (`id`) USING BTREE,
                                 INDEX `idx_publisher_id`(`publisher_id` ASC) USING BTREE,
                                 INDEX `idx_status_publish_time`(`status` ASC, `publish_time` ASC) USING BTREE,
                                 INDEX `idx_announcement_type`(`announcement_type` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of announcement
-- ----------------------------

-- ----------------------------
-- Table structure for api_log
-- ----------------------------
DROP TABLE IF EXISTS `api_log`;
CREATE TABLE `api_log`  (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `api_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'API路径',
                            `method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '请求方法',
                            `request_params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '请求参数',
                            `response_data` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '响应数据',
                            `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
                            `ip_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'IP地址',
                            `response_time` int NULL DEFAULT NULL COMMENT '响应时间(ms)',
                            `status_code` int NULL DEFAULT NULL COMMENT '状态码',
                            `error_message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '错误信息',
                            `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
                            PRIMARY KEY (`id`) USING BTREE,
                            INDEX `idx_api_path`(`api_path` ASC) USING BTREE,
                            INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
                            INDEX `idx_create_time`(`create_time` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'API调用日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_log
-- ----------------------------

-- ----------------------------
-- Table structure for check_in_record
-- ----------------------------
DROP TABLE IF EXISTS `check_in_record`;
CREATE TABLE `check_in_record`  (
                                    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '记录ID',
                                    `reservation_id` bigint NOT NULL COMMENT '预约ID',
                                    `user_id` bigint NOT NULL COMMENT '用户ID',
                                    `seat_id` bigint NOT NULL COMMENT '座位ID',
                                    `action_type` enum('check_in','check_out','temporary_leave','return','force_checkout') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '操作类型',
                                    `action_time` datetime NOT NULL COMMENT '操作时间',
                                    `action_method` enum('qrcode','face','manual','system','admin') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '操作方式',
                                    `device_info` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '设备信息',
                                    `ip_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'IP地址',
                                    `location` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '位置信息',
                                    `remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
                                    PRIMARY KEY (`id`) USING BTREE,
                                    INDEX `idx_reservation_id`(`reservation_id` ASC) USING BTREE,
                                    INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
                                    INDEX `idx_action_time`(`action_time` ASC) USING BTREE,
                                    CONSTRAINT `check_in_record_ibfk_1` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '签到记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of check_in_record
-- ----------------------------

-- ----------------------------
-- Table structure for credit_record
-- ----------------------------
DROP TABLE IF EXISTS `credit_record`;
CREATE TABLE `credit_record`  (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '记录ID',
                                  `user_id` bigint NOT NULL COMMENT '用户ID',
                                  `change_type` enum('initial','reservation_completed','violation_deduction','admin_adjust','appeal_recovery','system_adjust','other') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '变更类型',
                                  `change_value` int NOT NULL COMMENT '变更值（正负）',
                                  `current_credit` int NOT NULL COMMENT '变更后信用分',
                                  `related_id` bigint NULL DEFAULT NULL COMMENT '关联ID（预约ID或违规ID）',
                                  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '变更描述',
                                  `operator_id` bigint NULL DEFAULT NULL COMMENT '操作人ID（系统为0）',
                                  `operator_type` enum('system','user','admin') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'system' COMMENT '操作人类型',
                                  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  PRIMARY KEY (`id`) USING BTREE,
                                  INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
                                  INDEX `idx_change_type`(`change_type` ASC) USING BTREE,
                                  INDEX `idx_create_time`(`create_time` ASC) USING BTREE,
                                  CONSTRAINT `credit_record_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '信用分变更记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of credit_record
-- ----------------------------

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification`  (
                                 `id` bigint NOT NULL AUTO_INCREMENT COMMENT '通知ID',
                                 `user_id` bigint NOT NULL COMMENT '用户ID',
                                 `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '通知标题',
                                 `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '通知内容',
                                 `notification_type` enum('reservation','system','violation','announcement','reminder','other') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '通知类型',
                                 `related_id` bigint NULL DEFAULT NULL COMMENT '关联ID',
                                 `related_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '关联类型',
                                 `is_read` tinyint(1) NULL DEFAULT 0 COMMENT '是否已读',
                                 `read_time` datetime NULL DEFAULT NULL COMMENT '阅读时间',
                                 `is_sent` tinyint(1) NULL DEFAULT 0 COMMENT '是否已发送',
                                 `send_time` datetime NULL DEFAULT NULL COMMENT '发送时间',
                                 `send_method` json NULL COMMENT '发送方式（JSON数组）',
                                 `expire_time` datetime NULL DEFAULT NULL COMMENT '过期时间',
                                 `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                 PRIMARY KEY (`id`) USING BTREE,
                                 INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
                                 INDEX `idx_notification_type`(`notification_type` ASC) USING BTREE,
                                 INDEX `idx_is_read`(`is_read` ASC) USING BTREE,
                                 INDEX `idx_create_time`(`create_time` ASC) USING BTREE,
                                 CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '消息通知表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notification
-- ----------------------------

-- ----------------------------
-- Table structure for operation_log
-- ----------------------------
DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log`  (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '日志ID',
                                  `user_id` bigint NULL DEFAULT NULL COMMENT '用户ID',
                                  `user_type` enum('student','admin','system') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户类型',
                                  `operation_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '操作类型',
                                  `operation_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '操作内容',
                                  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '请求方法',
                                  `request_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '请求URL',
                                  `request_params` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '请求参数',
                                  `response_result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '响应结果',
                                  `ip_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'IP地址',
                                  `user_agent` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户代理',
                                  `status` tinyint(1) NULL DEFAULT 1 COMMENT '状态：0-失败，1-成功',
                                  `error_message` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '错误信息',
                                  `cost_time` bigint NULL DEFAULT NULL COMMENT '耗时（毫秒）',
                                  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  PRIMARY KEY (`id`) USING BTREE,
                                  INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
                                  INDEX `idx_operation_type`(`operation_type` ASC) USING BTREE,
                                  INDEX `idx_create_time`(`create_time` ASC) USING BTREE,
                                  INDEX `idx_ip_address`(`ip_address` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operation_log
-- ----------------------------

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation`  (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '预约ID',
                                `reservation_no` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '预约单号',
                                `user_id` bigint NOT NULL COMMENT '用户ID',
                                `seat_id` bigint NOT NULL COMMENT '座位ID',
                                `room_id` bigint NOT NULL COMMENT '自习室ID',
                                `start_time` datetime NOT NULL COMMENT '预约开始时间',
                                `end_time` datetime NOT NULL COMMENT '预约结束时间',
                                `expected_duration` int NULL DEFAULT NULL COMMENT '预计时长（分钟）',
                                `actual_duration` int NULL DEFAULT NULL COMMENT '实际时长（分钟）',
                                `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '状态：pending/confirmed/checked_in/in_use/temporary_leave/completed/cancelled/no_show/expired',
                                `cancel_reason` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '取消原因',
                                `cancel_time` datetime NULL DEFAULT NULL COMMENT '取消时间',
                                `check_in_time` datetime NULL DEFAULT NULL COMMENT '签到时间',
                                `check_out_time` datetime NULL DEFAULT NULL COMMENT '签退时间',
                                `check_in_method` enum('qrcode','face','manual') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '签到方式',
                                `check_in_qrcode` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '签到二维码内容',
                                `check_in_qrcode_expire` datetime NULL DEFAULT NULL COMMENT '二维码过期时间',
                                `leave_time` datetime NULL DEFAULT NULL COMMENT '暂离时间',
                                `return_time` datetime NULL DEFAULT NULL COMMENT '返回时间',
                                `leave_duration` int NULL DEFAULT 0 COMMENT '暂离时长（分钟）',
                                `max_leave_minutes` int NULL DEFAULT 15 COMMENT '允许暂离最大分钟数',
                                `is_violation` tinyint(1) NULL DEFAULT 0 COMMENT '是否违约',
                                `violation_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '违约类型',
                                `deduct_credit` int NULL DEFAULT 0 COMMENT '扣除信用分',
                                `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                `deleted` tinyint(1) NULL DEFAULT 0,
                                `reservation_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT 'normal' COMMENT '预约类型',
                                PRIMARY KEY (`id`) USING BTREE,
                                UNIQUE INDEX `uk_reservation_no`(`reservation_no` ASC) USING BTREE,
                                INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
                                INDEX `idx_seat_id`(`seat_id` ASC) USING BTREE,
                                INDEX `idx_room_id`(`room_id` ASC) USING BTREE,
                                INDEX `idx_start_end_time`(`start_time` ASC, `end_time` ASC) USING BTREE,
                                INDEX `idx_status`(`status` ASC) USING BTREE,
                                INDEX `idx_check_in_time`(`check_in_time` ASC) USING BTREE,
                                CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                CONSTRAINT `reservation_ibfk_3` FOREIGN KEY (`room_id`) REFERENCES `study_room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservation
-- ----------------------------

-- ----------------------------
-- Table structure for reservation_rule
-- ----------------------------
DROP TABLE IF EXISTS `reservation_rule`;
CREATE TABLE `reservation_rule`  (
                                     `id` bigint NOT NULL AUTO_INCREMENT COMMENT '规则ID',
                                     `rule_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '规则键',
                                     `rule_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '规则名称',
                                     `rule_value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '规则值',
                                     `rule_type` enum('duration','time','frequency','penalty','other') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '规则类型',
                                     `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '规则描述',
                                     `is_enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否启用',
                                     `priority` int NULL DEFAULT 0 COMMENT '优先级',
                                     `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                     `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                     PRIMARY KEY (`id`) USING BTREE,
                                     UNIQUE INDEX `uk_rule_key`(`rule_key` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '预约规则配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservation_rule
-- ----------------------------

-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat`  (
                         `id` bigint NOT NULL AUTO_INCREMENT COMMENT '座位ID',
                         `room_id` bigint NOT NULL COMMENT '自习室ID',
                         `seat_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '座位编码（如：A01）',
                         `seat_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '座位号',
                         `seat_type` enum('normal','vip','disabled','standing') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'normal' COMMENT '座位类型',
                         `status` enum('available','reserved','in_use','maintenance','unavailable') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'available' COMMENT '座位状态',
                         `current_reservation_id` bigint NULL DEFAULT NULL COMMENT '当前预约ID',
                         `current_user_id` bigint NULL DEFAULT NULL COMMENT '当前使用人ID',
                         `row_index` int NULL DEFAULT NULL COMMENT '行索引',
                         `col_index` int NULL DEFAULT NULL COMMENT '列索引',
                         `position_x` int NULL DEFAULT NULL COMMENT 'X坐标',
                         `position_y` int NULL DEFAULT NULL COMMENT 'Y坐标',
                         `position_config` json NULL COMMENT '位置配置（JSON）',
                         `has_power` tinyint(1) NULL DEFAULT 0 COMMENT '是否有电源',
                         `has_desk_lamp` tinyint(1) NULL DEFAULT 0 COMMENT '是否有台灯',
                         `is_window_seat` tinyint(1) NULL DEFAULT 0 COMMENT '是否靠窗',
                         `is_quiet_zone` tinyint(1) NULL DEFAULT 0 COMMENT '是否静音区',
                         `tags` json NULL COMMENT '标签（JSON数组）',
                         `usage_count` int NULL DEFAULT 0 COMMENT '使用次数',
                         `popularity_score` int NULL DEFAULT 0 COMMENT '受欢迎程度',
                         `last_used_time` datetime NULL DEFAULT NULL COMMENT '最后使用时间',
                         `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                         `create_by` bigint NULL DEFAULT NULL,
                         `update_by` bigint NULL DEFAULT NULL,
                         `deleted` tinyint(1) NULL DEFAULT 0,
                         PRIMARY KEY (`id`) USING BTREE,
                         UNIQUE INDEX `uk_room_seat_code`(`room_id` ASC, `seat_code` ASC) USING BTREE,
                         INDEX `idx_room_id_status`(`room_id` ASC, `status` ASC) USING BTREE,
                         INDEX `idx_current_user`(`current_user_id` ASC) USING BTREE,
                         INDEX `idx_seat_type`(`seat_type` ASC) USING BTREE,
                         CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `study_room` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '座位表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seat
-- ----------------------------

-- ----------------------------
-- Table structure for statistics_snapshot
-- ----------------------------
DROP TABLE IF EXISTS `statistics_snapshot`;
CREATE TABLE `statistics_snapshot`  (
                                        `id` bigint NOT NULL AUTO_INCREMENT COMMENT '快照ID',
                                        `snapshot_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '快照类型',
                                        `snapshot_date` date NOT NULL COMMENT '快照日期',
                                        `data_json` json NOT NULL COMMENT '统计数据（JSON格式）',
                                        `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                        PRIMARY KEY (`id`) USING BTREE,
                                        UNIQUE INDEX `uk_type_date`(`snapshot_type` ASC, `snapshot_date` ASC) USING BTREE,
                                        INDEX `idx_snapshot_date`(`snapshot_date` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '统计快照表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of statistics_snapshot
-- ----------------------------

-- ----------------------------
-- Table structure for study_room
-- ----------------------------
DROP TABLE IF EXISTS `study_room`;
CREATE TABLE `study_room`  (
                               `id` bigint NOT NULL AUTO_INCREMENT COMMENT '自习室ID',
                               `room_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '自习室编码（唯一）',
                               `room_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '自习室名称',
                               `building` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '楼栋',
                               `floor` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '楼层',
                               `location` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '具体位置描述',
                               `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '自习室描述',
                               `cover_image` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '封面图片',
                               `layout_image` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '布局图',
                               `total_seats` int NOT NULL DEFAULT 0 COMMENT '总座位数',
                               `available_seats` int NOT NULL DEFAULT 0 COMMENT '可用座位数',
                               `rows` int NULL DEFAULT NULL COMMENT '行数',
                               `cols` int NULL DEFAULT NULL COMMENT '列数',
                               `layout_config` json NULL COMMENT '布局配置（JSON格式）',
                               `open_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '开放状态：0-关闭，1-开放',
                               `open_time_config` json NULL COMMENT '开放时间配置（JSON）',
                               `advance_reservation_hours` int NULL DEFAULT 24 COMMENT '可提前预约小时数',
                               `min_reservation_minutes` int NULL DEFAULT 30 COMMENT '最小预约时长（分钟）',
                               `max_reservation_minutes` int NULL DEFAULT 240 COMMENT '最大预约时长（分钟）',
                               `facilities` json NULL COMMENT '设施列表（JSON数组）',
                               `has_power` tinyint(1) NULL DEFAULT 1 COMMENT '是否有电源',
                               `has_wifi` tinyint(1) NULL DEFAULT 1 COMMENT '是否有WiFi',
                               `has_air_conditioner` tinyint(1) NULL DEFAULT 1 COMMENT '是否有空调',
                               `has_water` tinyint(1) NULL DEFAULT 1 COMMENT '是否有饮水机',
                               `popularity_score` int NULL DEFAULT 0 COMMENT '受欢迎程度评分',
                               `usage_count` int NULL DEFAULT 0 COMMENT '使用次数',
                               `average_rating` decimal(3, 2) NULL DEFAULT 0.00 COMMENT '平均评分',
                               `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                               `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                               `create_by` bigint NULL DEFAULT NULL,
                               `update_by` bigint NULL DEFAULT NULL,
                               `deleted` tinyint(1) NULL DEFAULT 0,
                               PRIMARY KEY (`id`) USING BTREE,
                               UNIQUE INDEX `uk_room_code`(`room_code` ASC) USING BTREE,
                               INDEX `idx_building_floor`(`building` ASC, `floor` ASC) USING BTREE,
                               INDEX `idx_open_status`(`open_status` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '自习室表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of study_room
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
                             `role_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色编码',
                             `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
                             `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '角色描述',
                             `permissions` json NULL COMMENT '权限列表（JSON数组）',
                             `data_scope` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT 'SELF' COMMENT '数据权限范围',
                             `status` tinyint(1) NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             `create_by` bigint NULL DEFAULT NULL,
                             `update_by` bigint NULL DEFAULT NULL,
                             PRIMARY KEY (`id`) USING BTREE,
                             UNIQUE INDEX `uk_role_code`(`role_code` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                             `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名（学号/工号）',
                             `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '加密后的密码',
                             `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '真实姓名',
                             `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '昵称',
                             `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
                             `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '手机号',
                             `avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像URL',
                             `gender` tinyint(1) NULL DEFAULT 0 COMMENT '性别：0-未知，1-男，2-女',
                             `student_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学号（仅学生）',
                             `college` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学院',
                             `major` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '专业',
                             `grade` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '年级',
                             `class_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '班级',
                             `identity_status` tinyint(1) NULL DEFAULT 0 COMMENT '实名认证状态：0-未认证，1-已认证，2-审核中，3-认证失败',
                             `identity_card` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '身份证号（加密存储）',
                             `identity_face_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '人脸照片URL',
                             `credit_score` int NOT NULL DEFAULT 100 COMMENT '信用分（初始100）',
                             `total_reservations` int NULL DEFAULT 0 COMMENT '累计预约次数',
                             `completed_reservations` int NULL DEFAULT 0 COMMENT '完成预约次数',
                             `violation_count` int NULL DEFAULT 0 COMMENT '违规次数',
                             `role_type` enum('student','admin','super_admin') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'student' COMMENT '角色类型',
                             `role_id` bigint NULL DEFAULT NULL COMMENT '角色ID（关联sys_role）',
                             `permissions` json NULL COMMENT '权限列表（JSON数组）',
                             `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态：0-禁用，1-正常，2-锁定',
                             `last_login_time` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
                             `last_login_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '最后登录IP',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                             `create_by` bigint NULL DEFAULT NULL COMMENT '创建人',
                             `update_by` bigint NULL DEFAULT NULL COMMENT '更新人',
                             `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除：0-未删除，1-已删除',
                             `created_at` datetime NULL DEFAULT NULL COMMENT '前端字段：创建时间',
                             `updated_at` datetime NULL DEFAULT NULL COMMENT '前端字段：更新时间',
                             PRIMARY KEY (`id`) USING BTREE,
                             UNIQUE INDEX `uk_username`(`username` ASC) USING BTREE,
                             UNIQUE INDEX `uk_student_id`(`student_id` ASC) USING BTREE,
                             UNIQUE INDEX `uk_phone`(`phone` ASC) USING BTREE,
                             INDEX `idx_role_type`(`role_type` ASC) USING BTREE,
                             INDEX `idx_college_major`(`college` ASC, `major` ASC) USING BTREE,
                             INDEX `idx_status`(`status` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户表（学生/管理员）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for system_config
-- ----------------------------
DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config`  (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '配置ID',
                                  `config_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '配置键',
                                  `config_value` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '配置值',
                                  `config_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '配置类型',
                                  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '描述',
                                  `is_public` tinyint(1) NULL DEFAULT 0 COMMENT '是否公开',
                                  `status` tinyint(1) NULL DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
                                  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                  `create_by` bigint NULL DEFAULT NULL,
                                  `update_by` bigint NULL DEFAULT NULL,
                                  PRIMARY KEY (`id`) USING BTREE,
                                  UNIQUE INDEX `uk_config_key`(`config_key` ASC) USING BTREE,
                                  INDEX `idx_config_type`(`config_type` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '系统配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_config
-- ----------------------------

-- ----------------------------
-- Table structure for violation_record
-- ----------------------------
DROP TABLE IF EXISTS `violation_record`;
CREATE TABLE `violation_record`  (
                                     `id` bigint NOT NULL AUTO_INCREMENT COMMENT '违规ID',
                                     `user_id` bigint NOT NULL COMMENT '用户ID',
                                     `reservation_id` bigint NULL DEFAULT NULL COMMENT '预约ID',
                                     `violation_type` enum('no_show','late_checkin','early_checkout','overstay','no_checkout','fake_checkin','other') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '违规类型',
                                     `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '违规描述',
                                     `deduct_credit` int NOT NULL DEFAULT 0 COMMENT '扣除信用分',
                                     `penalty_level` enum('minor','medium','major','serious') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT 'minor' COMMENT '违规等级',
                                     `handle_status` enum('pending','processed','appealing','appealed','cancelled') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'pending' COMMENT '处理状态',
                                     `handler_id` bigint NULL DEFAULT NULL COMMENT '处理人ID',
                                     `handle_time` datetime NULL DEFAULT NULL COMMENT '处理时间',
                                     `handle_remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '处理备注',
                                     `appeal_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '申诉内容',
                                     `appeal_time` datetime NULL DEFAULT NULL COMMENT '申诉时间',
                                     `appeal_result` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '申诉结果',
                                     `appeal_remarks` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '申诉备注',
                                     `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                     `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                     PRIMARY KEY (`id`) USING BTREE,
                                     INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
                                     INDEX `idx_violation_type`(`violation_type` ASC) USING BTREE,
                                     INDEX `idx_handle_status`(`handle_status` ASC) USING BTREE,
                                     INDEX `idx_create_time`(`create_time` ASC) USING BTREE,
                                     INDEX `reservation_id`(`reservation_id` ASC) USING BTREE,
                                     CONSTRAINT `violation_record_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                     CONSTRAINT `violation_record_ibfk_2` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '违规记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of violation_record
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
