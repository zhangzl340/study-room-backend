package com.studyroom.modules.checkin.dto.request;

import lombok.Data;

@Data
public class LeaveRequest {
    private Long checkInId;
    private Integer maxLeaveMinutes;
    private String remarks;
}
