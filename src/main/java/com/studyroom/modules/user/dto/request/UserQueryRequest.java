package com.studyroom.modules.user.dto.request;

import lombok.Data;

@Data
public class UserQueryRequest {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private String username;

    private String realName;

    private String studentId;

    private String email;

    private String phone;
    private String college;

    private String major;

    private String grade;

    private Integer status;

    private String roleType;

    private Integer identityStatus;

    private String keyword;
}
