package com.studyroom.modules.room.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.studyroom.common.enums.SeatStatusEnum;
import com.studyroom.common.enums.SeatTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SeatVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long roomId;
    private String seatCode;
    private String seatNumber;
    private String seatType;
    private String status;
    private Long currentReservationId;
    private Long currentUserId;
    private Integer rowIndex;
    private Integer colIndex;
    private Integer positionX;
    private Integer positionY;
    private String positionConfig;
    private Integer hasPower;
    private Integer hasDeskLamp;
    private Integer isWindowSeat;
    private Integer isQuietZone;
    private String tags;
    private Integer usageCount;
    private Integer popularityScore;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUsedTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    private SeatTypeEnum seatTypeEnum;
    private SeatStatusEnum statusEnum;

    public SeatTypeEnum getSeatTypeEnum() {
        return SeatTypeEnum.getByCode(this.seatType);
    }

    public SeatStatusEnum getStatusEnum() {
        return SeatStatusEnum.getByCode(this.status);
    }
}
