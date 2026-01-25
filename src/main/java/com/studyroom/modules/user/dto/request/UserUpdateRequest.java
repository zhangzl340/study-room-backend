package com.studyroom.modules.user.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "更新用户请求")
public class UserUpdateRequest {
    @NotBlank(message = "用户名不能为空")
    @Schema(description = "用户名", required = true)
    private String username;

    @NotBlank(message = "密码不能为空")
    @Schema(description = "密码",required = true)
    private String password;


    @Schema(description = "手机号码", required = true)
    private String phone;

    @NotBlank(message = "真实姓名不能为空")
    @Schema(description = "真实姓名", required = true)
    private String realName;

    @Schema(description = "别名")
    private String nickname;

    @Email(message = "邮箱格式不正确")
    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "头像URL")
    private String avatar;

    @Schema(description = "性别")
    private Integer gender;
}
