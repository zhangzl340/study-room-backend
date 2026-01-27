package com.studyroom.modules.user.dto.request;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String college;
    private String major;
    private String studentId;
    private String role;
    private Integer creditScore;
}
