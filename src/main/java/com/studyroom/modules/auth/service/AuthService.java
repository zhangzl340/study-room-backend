package com.studyroom.modules.auth.service;

import com.studyroom.modules.auth.dto.request.ChangePasswordRequest;
import com.studyroom.modules.auth.dto.request.LoginRequest;
import com.studyroom.modules.auth.dto.request.RefreshTokenRequest;
import com.studyroom.modules.auth.dto.request.RegisterRequest;
import com.studyroom.modules.auth.dto.request.VerifyIdentityRequest;
import com.studyroom.modules.auth.dto.response.LoginResponse;
import com.studyroom.modules.auth.dto.response.RefreshTokenResponse;
import com.studyroom.modules.auth.dto.response.VerifyIdentityResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request, String ip);

    void register(RegisterRequest request);

    RefreshTokenResponse refreshToken(RefreshTokenRequest request);

    void logout(String token);

    void changePassword(Long userId, ChangePasswordRequest request);

    VerifyIdentityResponse verifyIdentity(Long userId, VerifyIdentityRequest request);
}
