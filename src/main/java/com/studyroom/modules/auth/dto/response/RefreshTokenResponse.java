package com.studyroom.modules.auth.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "刷新Token响应")
public class RefreshTokenResponse {

    @Schema(description = "新的访问令牌")
    private String accessToken;

    @Schema(description = "令牌类型")
    private String tokenType;

    @Schema(description = "过期时间（秒）")
    private Long expiresIn;
}
