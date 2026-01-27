package com.studyroom.modules.admin.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SystemLogVO {
    private Long id;
    private String level;
    private String message;
    private String timestamp;
    private Long userId;
    private String username;
    private String ip;
    private String userAgent;
    private String operation;
    private String module;
    private String details;
}
