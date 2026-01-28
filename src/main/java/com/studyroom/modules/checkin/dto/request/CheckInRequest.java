package com.studyroom.modules.checkin.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CheckInRequest {
    @NotNull(message = "预约ID不能为空")
    private Long reservationId;
    
    private Long seatId;
    
    private Long roomId;
    
    @NotBlank(message = "签到方式不能为空")
    private String checkInMethod;
    
    private String deviceInfo;
    
    private String ipAddress;
}
