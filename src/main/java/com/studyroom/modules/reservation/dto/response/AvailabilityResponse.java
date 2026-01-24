package com.studyroom.modules.reservation.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AvailabilityResponse {
    private final boolean available;
    private final String reason;
}
