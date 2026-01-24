package com.studyroom.modules.violation.dto.request;

import lombok.Data;

@Data
public class ViolationHandleRequest {
    private Long violationId;
    private String status;
    private String handleResult;
    private Integer deductCredit;
    private String remarks;
}
