package com.studyroom.modules.checkin.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LeaveRequest {
    @NotNull(message = "预约ID不能为空")
    private Long reservationId;
    private Long checkInId;
    private Integer maxLeaveMinutes;
    private String remarks;
}
