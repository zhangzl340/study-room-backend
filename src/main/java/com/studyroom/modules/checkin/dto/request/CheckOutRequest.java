package com.studyroom.modules.checkin.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CheckOutRequest {
    @NotNull(message = "签到ID不能为空")
    private Long checkInId;
    private String remarks;
}
