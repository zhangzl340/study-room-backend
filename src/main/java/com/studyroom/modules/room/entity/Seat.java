package com.studyroom.modules.room.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.studyroom.common.enums.SeatStatusEnum;
import com.studyroom.common.enums.SeatTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("seat")
public class Seat implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("room_id")
    private Long roomId;

    @TableField("seat_code")
    private String seatCode;

    @TableField("seat_number")
    private String seatNumber;

    @TableField("seat_type")
    private String seatType;

    @TableField("status")
    private String status;

    @TableField("current_reservation_id")
    private Long currentReservationId;

    @TableField("current_user_id")
    private Long currentUserId;

    @TableField("row_index")
    private Integer rowIndex;

    @TableField("col_index")
    private Integer colIndex;

    @TableField("position_x")
    private Integer positionX;

    @TableField("position_y")
    private Integer positionY;

    @TableField("position_config")
    private String positionConfig;

    @TableField("has_power")
    private Integer hasPower;

    @TableField("has_desk_lamp")
    private Integer hasDeskLamp;

    @TableField("is_window_seat")
    private Integer isWindowSeat;

    @TableField("is_quiet_zone")
    private Integer isQuietZone;

    @TableField("tags")
    private String tags;

    @TableField("usage_count")
    private Integer usageCount;

    @TableField("popularity_score")
    private Integer popularityScore;

    @TableField("last_used_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUsedTime;

    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @TableField("create_by")
    private Long createBy;

    @TableField("update_by")
    private Long updateBy;

    @TableLogic
    @TableField("deleted")
    private Integer deleted;

    @TableField(exist = false)
    private SeatTypeEnum seatTypeEnum;

    @TableField(exist = false)
    private SeatStatusEnum statusEnum;

    public SeatTypeEnum getSeatTypeEnum() {
        return SeatTypeEnum.getByCode(this.seatType);
    }

    public SeatStatusEnum getStatusEnum() {
        return SeatStatusEnum.getByCode(this.status);
    }
}
