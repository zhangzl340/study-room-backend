package com.studyroom.modules.user.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminVO {
    private Long id;
    private String username;
    private String realName;
    private String nickname;
    private String email;
    private String phone;
    private String avatar;
    private Integer gender;
    private String college;
    private String major;
    private String studentId;
    private String role;
    private Integer status;
    private Integer creditScore;
    private String roleType;
    private LocalDateTime createTime;
    private LocalDateTime lastLoginTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
