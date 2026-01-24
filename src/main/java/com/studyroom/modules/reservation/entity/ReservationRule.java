package com.studyroom.modules.reservation.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("reservation_rule")
public class ReservationRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("max_reservation_hours")
    private Integer maxReservationHours;

    @TableField("min_reservation_minutes")
    private Integer minReservationMinutes;

    @TableField("max_daily_reservations")
    private Integer maxDailyReservations;

    @TableField("advance_reservation_hours")
    private Integer advanceReservationHours;

    @TableField("cancellation_deadline_minutes")
    private Integer cancellationDeadlineMinutes;

    @TableField("no_show_penalty_minutes")
    private Integer noShowPenaltyMinutes;

    @TableField("active")
    private Integer active;

    @TableField("create_time")
    private java.time.LocalDateTime createTime;

    @TableField("update_time")
    private java.time.LocalDateTime updateTime;

    @TableLogic
    @TableField("deleted")
    private Integer deleted;
}
