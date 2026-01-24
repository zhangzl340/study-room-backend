package com.studyroom.modules.room.dto.request;

import lombok.Data;

@Data
public class SeatImportRequest {
    private Long roomId;
    private Integer rowCount;
    private Integer colCount;
}
