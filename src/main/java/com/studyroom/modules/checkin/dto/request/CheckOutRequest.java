package com.studyroom.modules.checkin.dto.request;

import lombok.Data;

@Data
public class CheckOutRequest {
    private Long checkInId;
    private String remarks;
}
