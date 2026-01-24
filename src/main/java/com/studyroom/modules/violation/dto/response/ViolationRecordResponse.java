package com.studyroom.modules.violation.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ViolationRecordResponse {
    private Long id;
    private Long userId;
    private String violationType;
    private String violationDesc;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime handleTime;
    private String handleResult;
    private Integer deductCredit;
    private String message;
}
