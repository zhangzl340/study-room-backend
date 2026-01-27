-- 更新statistics_snapshot表结构，添加缺失的字段
ALTER TABLE statistics_snapshot
ADD COLUMN `snapshot_type` VARCHAR(50) NULL COMMENT '快照类型',
ADD COLUMN `total_users` INT NULL COMMENT '总用户数',
ADD COLUMN `active_users` INT NULL COMMENT '活跃用户数',
ADD COLUMN `completed_reservations` INT NULL COMMENT '完成预约数',
ADD COLUMN `cancelled_reservations` INT NULL COMMENT '取消预约数',
ADD COLUMN `total_check_ins` INT NULL COMMENT '总签到数',
ADD COLUMN `total_violations` INT NULL COMMENT '总违规数',
ADD COLUMN `average_usage_rate` DOUBLE NULL COMMENT '平均使用率',
ADD COLUMN `peak_concurrent_users` INT NULL COMMENT '峰值并发用户数',
ADD COLUMN `total_study_hours` INT NULL COMMENT '总学习时长',
ADD COLUMN `average_credit_score` DOUBLE NULL COMMENT '平均信用分';

-- 修改字段名（如果需要）
-- 如果原表中字段名是date_json，需要修改为data_json
-- ALTER TABLE statistics_snapshot CHANGE COLUMN `date_json` `data_json` VARCHAR(2000) NULL COMMENT '数据JSON';

-- 添加索引
CREATE INDEX idx_snapshot_date ON statistics_snapshot(snapshot_date);
CREATE INDEX idx_snapshot_type ON statistics_snapshot(snapshot_type);
