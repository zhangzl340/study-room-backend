package com.studyroom.modules.auth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VerifyIdentityResponse {

    private Boolean verified;

    private String message;

    private String realName;

    private String idCard;
}
