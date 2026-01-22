package com.studyroom.modules.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.studyroom.common.enums.GenderEnum;
import com.studyroom.common.enums.IdentityStatusEnum;
import com.studyroom.common.enums.UserRoleEnum;
import com.studyroom.common.enums.UserStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("real_name")
    private String realName;

    @TableField("nickname")
    private String nickname;

    @TableField("email")
    private String email;

    @TableField("phone")
    private String phone;

    @TableField("avatar")
    private String avatar;

    @TableField("gender")
    private Integer gender;

    @TableField("student_id")
    private String studentId;

    @TableField("college")
    private String college;

    @TableField("major")
    private String major;

    @TableField("grade")
    private String grade;

    @TableField("class_name")
    private String className;

    @TableField("identity_status")
    private Integer identityStatus;

    @TableField("identity_card")
    private String identityCard;

    @TableField("identity_face_url")
    private String identityFaceUrl;

    @TableField("credit_score")
    private Integer creditScore;

    @TableField("total_reservations")
    private Integer totalReservations;

    @TableField("completed_reservations")
    private Integer completedReservations;

    @TableField("violation_count")
    private Integer violationCount;

    @TableField("role_type")
    private String roleType;

    @TableField("role_id")
    private Long roleId;

    @TableField("permissions")
    private String permissions;

    @TableField("status")
    private Integer status;

    @TableField("last_login_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLoginTime;

    @TableField("last_login_ip")
    private String lastLoginIp;

    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @TableField("create_by")
    private Long createBy;

    @TableField("update_by")
    private Long updateBy;

    @TableLogic
    @TableField("deleted")
    private Integer deleted;

    @JsonProperty("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    @TableField(exist = false)
    private GenderEnum genderEnum;

    @TableField(exist = false)
    private IdentityStatusEnum identityStatusEnum;

    @TableField(exist = false)
    private UserRoleEnum roleTypeEnum;

    @TableField(exist = false)
    private UserStatusEnum statusEnum;

    public GenderEnum getGenderEnum() {
        return GenderEnum.getByCode(this.gender);
    }

    public IdentityStatusEnum getIdentityStatusEnum() {
        return IdentityStatusEnum.getByCode(this.identityStatus);
    }

    public UserRoleEnum getRoleTypeEnum() {
        return UserRoleEnum.getByCode(this.roleType);
    }

    public UserStatusEnum getStatusEnum() {
        return UserStatusEnum.getByCode(this.status);
    }
}
