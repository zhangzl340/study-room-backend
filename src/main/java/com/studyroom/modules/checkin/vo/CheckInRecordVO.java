package com.studyroom.modules.checkin.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CheckInRecordVO {
    private Long id;
    private Long reservationId;
    private Long userId;
    private Long roomId;
    private Long seatId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkInTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkOutTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime leaveTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime returnTime;
    private String status;
    private String checkInMethod;
    private Integer actualDuration;
    private Integer leaveDuration;
    private Integer maxLeaveMinutes;
    private String deviceInfo;
    private String ipAddress;
    private String location;
    private String remarks;
}
