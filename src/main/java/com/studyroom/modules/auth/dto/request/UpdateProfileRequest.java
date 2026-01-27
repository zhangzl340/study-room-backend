package com.studyroom.modules.auth.dto.request;

import lombok.Data;

@Data
public class UpdateProfileRequest {
    private String email;
    private String phone;
    private String nickname;
    private String avatar;
    private String college;
    private String major;
    private String grade;
    private String className;
}
