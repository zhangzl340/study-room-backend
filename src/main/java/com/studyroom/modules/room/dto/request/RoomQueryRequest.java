package com.studyroom.modules.room.dto.request;

import lombok.Data;

@Data
public class RoomQueryRequest {
    private String building;
    private String floor;
    private Integer openStatus;
    private String roomName;
}
