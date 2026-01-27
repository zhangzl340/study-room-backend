package com.studyroom.modules.admin.dto.request;

import lombok.Data;

@Data
public class SystemSettingsUpdateRequest {
    private String systemName;
    private String systemVersion;
    private Boolean enableRegistration;
    private Boolean enableEmailVerification;
    private Boolean enableSmsVerification;
    private Integer maxLoginAttempts;
    private Integer lockoutDurationMinutes;
    private String defaultTimeZone;
    private String defaultLanguage;
}
