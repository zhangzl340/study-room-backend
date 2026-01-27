package com.studyroom.modules.admin.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationRulesVO {
    private Integer maxReservationPerDay;
    private Integer maxFutureDays;
    private Integer minReservationMinutes;
    private Integer maxReservationMinutes;
    private Integer checkInEarlyMinutes;
    private Integer checkInLateMinutes;
    private Integer autoCancelMinutes;
    private Integer tempLeaveMaxMinutes;
    private LocalDateTime lastUpdated;
    private String lastUpdatedBy;
}
