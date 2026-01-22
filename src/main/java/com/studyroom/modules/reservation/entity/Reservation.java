package com.studyroom.modules.reservation.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.studyroom.common.enums.CheckInMethodEnum;
import com.studyroom.common.enums.ReservationStatusEnum;
import com.studyroom.common.enums.ReservationTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("reservation")
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("reservation_no")
    private String reservationNo;

    @TableField("user_id")
    private Long userId;

    @TableField("seat_id")
    private Long seatId;

    @TableField("room_id")
    private Long roomId;

    @TableField("start_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @TableField("end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    @TableField("expected_duration")
    private Integer expectedDuration;

    @TableField("actual_duration")
    private Integer actualDuration;

    @TableField("status")
    private String status;

    @TableField("cancel_reason")
    private String cancelReason;

    @TableField("cancel_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime cancelTime;

    @TableField("check_in_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkInTime;

    @TableField("check_out_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkOutTime;

    @TableField("check_in_method")
    private String checkInMethod;

    @TableField("check_in_qrcode")
    private String checkInQrcode;

    @TableField("check_in_qrcode_expire")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkInQrcodeExpire;

    @TableField("leave_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime leaveTime;

    @TableField("return_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime returnTime;

    @TableField("leave_duration")
    private Integer leaveDuration;

    @TableField("max_leave_minutes")
    private Integer maxLeaveMinutes;

    @TableField("is_violation")
    private Integer isViolation;

    @TableField("violation_type")
    private String violationType;

    @TableField("deduct_credit")
    private Integer deductCredit;

    @TableField("reservation_type")
    private String reservationType;

    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @TableLogic
    @TableField("deleted")
    private Integer deleted;

    @TableField(exist = false)
    private ReservationStatusEnum statusEnum;

    @TableField(exist = false)
    private ReservationTypeEnum reservationTypeEnum;

    @TableField(exist = false)
    private CheckInMethodEnum checkInMethodEnum;

    public ReservationStatusEnum getStatusEnum() {
        return ReservationStatusEnum.getByCode(this.status);
    }

    public ReservationTypeEnum getReservationTypeEnum() {
        return ReservationTypeEnum.getByCode(this.reservationType);
    }

    public CheckInMethodEnum getCheckInMethodEnum() {
        return CheckInMethodEnum.getByCode(this.checkInMethod);
    }
}
