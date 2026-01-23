package com.studyroom.modules.user.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserListResponse {

    private Long id;

    private String username;

    private String realName;

    private String nickname;

    private String email;

    private String phone;

    private String avatar;

    private Integer gender;

    private String studentId;

    private String college;

    private String major;

    private String grade;

    private String className;

    private Integer identityStatus;

    private Integer creditScore;

    private Integer totalReservations;

    private Integer completedReservations;

    private Integer violationCount;

    private String roleType;

    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLoginTime;

    private String lastLoginIp;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PageData {

        private List<UserListResponse> records;

        private Long total;

        private Long pageNum;

        private Long pageSize;

        private Long pages;
    }
}
