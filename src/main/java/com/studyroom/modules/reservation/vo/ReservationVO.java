package com.studyroom.modules.reservation.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.studyroom.common.enums.CheckInMethodEnum;
import com.studyroom.common.enums.ReservationStatusEnum;
import com.studyroom.common.enums.ReservationTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ReservationVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String reservationNo;
    private Long userId;
    private Long seatId;
    private Long roomId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    private Integer expectedDuration;
    private Integer actualDuration;
    private String status;
    private String cancelReason;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime cancelTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkInTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkOutTime;
    private String checkInMethod;
    private String checkInQrcode;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkInQrcodeExpire;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime leaveTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime returnTime;
    private Integer leaveDuration;
    private Integer maxLeaveMinutes;
    private Integer isViolation;
    private String violationType;
    private Integer deductCredit;
    private String reservationType;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    private ReservationStatusEnum statusEnum;
    private ReservationTypeEnum reservationTypeEnum;
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
