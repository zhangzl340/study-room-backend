package com.studyroom.modules.statistics.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@TableName("statistics_snapshot")
public class StatisticsSnapshot implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "snapshot_type")
    private String snapshotType;

    @TableField(value = "snapshot_date")
    private LocalDate snapshotDate;

    @TableField(value = "data_json")
    private String dataJson;

    @TableField(value = "total_users")
    private Integer totalUsers;

    @TableField(value = "active_users")
    private Integer activeUsers;

    @TableField(value = "total_reservations")
    private Integer totalReservations;

    @TableField(value = "completed_reservations")
    private Integer completedReservations;

    @TableField(value = "cancelled_reservations")
    private Integer cancelledReservations;

    @TableField(value = "total_check_ins")
    private Integer totalCheckIns;

    @TableField(value = "total_violations")
    private Integer totalViolations;

    @TableField(value = "average_usage_rate")
    private Double averageUsageRate;

    @TableField(value = "peak_concurrent_users")
    private Integer peakConcurrentUsers;

    @TableField(value = "total_study_hours")
    private Integer totalStudyHours;

    @TableField(value = "average_credit_score")
    private Double averageCreditScore;

    @TableField(value = "create_time")
    private LocalDateTime createTime;
}
