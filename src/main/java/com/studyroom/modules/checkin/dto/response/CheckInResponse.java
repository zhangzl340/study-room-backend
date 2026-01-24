package com.studyroom.modules.checkin.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CheckInResponse {
    private LocalDateTime checkInTime;
    private Long seatId;
    private Long roomId;
    private String checkInMethod;
    private String message;
}
