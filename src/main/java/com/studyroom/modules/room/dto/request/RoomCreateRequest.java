package com.studyroom.modules.room.dto.request;

import lombok.Data;

@Data
public class RoomCreateRequest {
    private String roomCode;
    private String roomName;
    private String building;
    private String floor;
    private String location;
    private String description;
    private String coverImage;
    private String layoutImage;
    private Integer totalSeats;
    private Integer rowCount;
    private Integer colCount;
    private String layoutConfig;
    private String openTimeConfig;
    private Integer advanceReservationHours;
    private Integer minReservationMinutes;
    private Integer maxReservationMinutes;
    private String facilities;
    private Integer hasPower;
    private Integer hasWifi;
    private Integer hasAirConditioner;
    private Integer hasWater;
}
