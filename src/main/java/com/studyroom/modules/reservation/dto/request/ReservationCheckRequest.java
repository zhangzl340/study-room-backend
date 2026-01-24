package com.studyroom.modules.reservation.dto.request;

import lombok.Data;

@Data
public class ReservationCheckRequest {
    private Long reservationId;
    private String checkInMethod;
}
