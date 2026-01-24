package com.studyroom.modules.reservation.dto.request;

import lombok.Data;

@Data
public class ReservationQueryRequest {
    private Long userId;
    private Long roomId;
    private Long seatId;
    private String status;
    private String reservationType;
    private String startDate;
    private String endDate;
}
