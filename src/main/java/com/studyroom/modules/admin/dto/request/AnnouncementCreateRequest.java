package com.studyroom.modules.admin.dto.request;

import lombok.Data;

@Data
public class AnnouncementCreateRequest {
    private String title;
    private String content;
    private String type;
    private Boolean isActive;
}
