package com.studyroom.modules.room.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RoomVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String roomCode;
    private String roomName;
    private String building;
    private String floor;
    private String location;
    private String description;
    private String coverImage;
    private String layoutImage;
    private Integer totalSeats;
    private Integer availableSeats;
    private Integer rowCount;
    private Integer colCount;
    private String layoutConfig;
    private Integer openStatus;
    private String openTimeConfig;
    private Integer advanceReservationHours;
    private Integer minReservationMinutes;
    private Integer maxReservationMinutes;
    private String facilities;
    private Integer hasPower;
    private Integer hasWifi;
    private Integer hasAirConditioner;
    private Integer hasWater;
    private Integer popularityScore;
    private Integer usageCount;
    private BigDecimal averageRating;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
