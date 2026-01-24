package com.studyroom.modules.room.dto.request;

import lombok.Data;

@Data
public class SeatLayoutUpdateRequest {
    private Long roomId;
    private String layoutConfig;
}
