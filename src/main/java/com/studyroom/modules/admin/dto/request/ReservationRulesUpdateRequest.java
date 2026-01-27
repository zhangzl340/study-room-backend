package com.studyroom.modules.admin.dto.request;

import lombok.Data;

@Data
public class ReservationRulesUpdateRequest {
    private Integer maxReservationPerDay;
    private Integer maxFutureDays;
    private Integer minReservationMinutes;
    private Integer maxReservationMinutes;
    private Integer checkInEarlyMinutes;
    private Integer checkInLateMinutes;
    private Integer autoCancelMinutes;
    private Integer tempLeaveMaxMinutes;
}
