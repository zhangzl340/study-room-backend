package com.studyroom.modules.admin.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SystemSettingsVO {
    private String systemName;
    private String systemVersion;
    private Boolean enableRegistration;
    private Boolean enableEmailVerification;
    private Boolean enableSmsVerification;
    private Integer maxLoginAttempts;
    private Integer lockoutDurationMinutes;
    private String defaultTimeZone;
    private String defaultLanguage;
    private LocalDateTime lastUpdated;
    private String lastUpdatedBy;
}
