package com.studyroom.modules.room.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("study_room")
public class StudyRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("room_code")
    private String roomCode;

    @TableField("room_name")
    private String roomName;

    @TableField("building")
    private String building;

    @TableField("floor")
    private String floor;

    @TableField("location")
    private String location;

    @TableField("description")
    private String description;

    @TableField("cover_image")
    private String coverImage;

    @TableField("layout_image")
    private String layoutImage;

    @TableField("total_seats")
    private Integer totalSeats;

    @TableField("available_seats")
    private Integer availableSeats;

    @TableField("rows")
    private Integer rows;

    @TableField("cols")
    private Integer cols;

    @TableField("layout_config")
    private String layoutConfig;

    @TableField("open_status")
    private Integer openStatus;

    @TableField("open_time_config")
    private String openTimeConfig;

    @TableField("advance_reservation_hours")
    private Integer advanceReservationHours;

    @TableField("min_reservation_minutes")
    private Integer minReservationMinutes;

    @TableField("max_reservation_minutes")
    private Integer maxReservationMinutes;

    @TableField("facilities")
    private String facilities;

    @TableField("has_power")
    private Integer hasPower;

    @TableField("has_wifi")
    private Integer hasWifi;

    @TableField("has_air_conditioner")
    private Integer hasAirConditioner;

    @TableField("has_water")
    private Integer hasWater;

    @TableField("popularity_score")
    private Integer popularityScore;

    @TableField("usage_count")
    private Integer usageCount;

    @TableField("average_rating")
    private BigDecimal averageRating;

    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @TableField("create_by")
    private Long createBy;

    @TableField("update_by")
    private Long updateBy;

    @TableLogic
    @TableField("deleted")
    private Integer deleted;
}
