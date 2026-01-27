package com.studyroom.modules.reservation.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationCreateRequest {
    private Long roomId;
    private Long seatId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer expectedDuration;
    private String reservationType;
//    private String purpose;
}
