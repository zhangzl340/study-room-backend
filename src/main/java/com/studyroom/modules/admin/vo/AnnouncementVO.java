package com.studyroom.modules.admin.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnnouncementVO {
    private Long id;
    private String title;
    private String content;
    private String type;
    private Boolean isActive;
    private LocalDateTime publishTime;
    private String publisher;
}
