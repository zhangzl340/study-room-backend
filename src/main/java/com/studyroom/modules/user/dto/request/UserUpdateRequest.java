package com.studyroom.modules.user.dto.request;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String name;
    private String email;
    private String phone;
    private String college;
    private String major;
    private String studentId;
    private String role;
    private Integer creditScore;
}
