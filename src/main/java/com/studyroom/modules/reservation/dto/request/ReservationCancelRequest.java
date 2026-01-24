package com.studyroom.modules.reservation.dto.request;

import lombok.Data;

@Data
public class ReservationCancelRequest {
    private Long reservationId;
    private String cancelReason;
}
