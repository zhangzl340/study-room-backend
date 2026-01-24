package com.studyroom.modules.checkin.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.studyroom.common.enums.CheckInActionEnum;
import com.studyroom.common.enums.CheckInMethodEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("check_in_record")
public class CheckInRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("reservation_id")
    private Long reservationId;

    @TableField("user_id")
    private Long userId;

    @TableField("room_id")
    private Long roomId;

    @TableField("seat_id")
    private Long seatId;

    @TableField("check_in_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkInTime;

    @TableField("check_out_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkOutTime;

    @TableField("leave_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime leaveTime;

    @TableField("return_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime returnTime;

    @TableField("status")
    private String status;

    @TableField("check_in_method")
    private String checkInMethod;

    @TableField("actual_duration")
    private Integer actualDuration;

    @TableField("leave_duration")
    private Integer leaveDuration;

    @TableField("max_leave_minutes")
    private Integer maxLeaveMinutes;

    @TableField("device_info")
    private String deviceInfo;

    @TableField("ip_address")
    private String ipAddress;

    @TableField("location")
    private String location;

    @TableField("remarks")
    private String remarks;

    @TableField("action_type")
    private String actionType;

    @TableField("action_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime actionTime;

    @TableField("action_method")
    private String actionMethod;

    @TableField(exist = false)
    private CheckInActionEnum actionTypeEnum;

    @TableField(exist = false)
    private CheckInMethodEnum checkInMethodEnum;

    public CheckInActionEnum getActionTypeEnum() {
        return CheckInActionEnum.getByCode(this.actionType);
    }

    public CheckInMethodEnum getCheckInMethodEnum() {
        return CheckInMethodEnum.getByCode(this.checkInMethod);
    }
}
