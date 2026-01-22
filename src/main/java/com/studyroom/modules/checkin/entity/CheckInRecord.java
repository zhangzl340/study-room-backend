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

    @TableField("seat_id")
    private Long seatId;

    @TableField("action_type")
    private String actionType;

    @TableField("action_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime actionTime;

    @TableField("action_method")
    private String actionMethod;

    @TableField("device_info")
    private String deviceInfo;

    @TableField("ip_address")
    private String ipAddress;

    @TableField("location")
    private String location;

    @TableField("remarks")
    private String remarks;

    @TableField(exist = false)
    private CheckInActionEnum actionTypeEnum;

    @TableField(exist = false)
    private CheckInMethodEnum actionMethodEnum;

    public CheckInActionEnum getActionTypeEnum() {
        return CheckInActionEnum.getByCode(this.actionType);
    }

    public CheckInMethodEnum getActionMethodEnum() {
        return CheckInMethodEnum.getByCode(this.actionMethod);
    }
}
