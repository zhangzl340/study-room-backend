package com.studyroom.modules.checkin.dto.request;

import lombok.Data;

@Data
public class CheckInRequest {
    private Long reservationId;
    private Long seatId;
    private Long roomId;
    private String checkInMethod;
    private String deviceInfo;
    private String ipAddress;
}
