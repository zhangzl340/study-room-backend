package com.studyroom.modules.auth.controller;

import com.studyroom.common.exception.BusinessException;
import com.studyroom.common.result.Result;
import com.studyroom.modules.auth.dto.request.ChangePasswordRequest;
import com.studyroom.modules.auth.dto.request.LoginRequest;
import com.studyroom.modules.auth.dto.request.RefreshTokenRequest;
import com.studyroom.modules.auth.dto.request.RegisterRequest;
import com.studyroom.modules.auth.dto.request.VerifyIdentityRequest;
import com.studyroom.modules.auth.dto.response.LoginResponse;
import com.studyroom.modules.auth.dto.response.RefreshTokenResponse;
import com.studyroom.modules.auth.dto.response.VerifyIdentityResponse;
import com.studyroom.modules.auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "认证接口", description = "用户登录、注册、Token管理")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public Result<LoginResponse> login(@Valid @RequestBody LoginRequest request, HttpServletRequest httpRequest) {
        try {
            String ip = getClientIp(httpRequest);
            LoginResponse response = authService.login(request, ip);
            return Result.success(response);
        } catch (BusinessException e) {
            log.error("登录业务异常: {}", e.getMessage());
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            log.error("登录异常", e);
            return Result.error(500, "系统异常，请稍后重试");
        }
    }

    @PostMapping("/register")
    @Operation(summary = "用户注册")
    public Result<Void> register(@Valid @RequestBody RegisterRequest request) {
        authService.register(request);
        return Result.success("注册成功");
    }

    @PostMapping("/refresh-token")
    @Operation(summary = "刷新Token")
    public Result<RefreshTokenResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest request) {
        RefreshTokenResponse response = authService.refreshToken(request);
        return Result.success(response);
    }

    @PostMapping("/logout")
    @Operation(summary = "用户登出")
    public Result<Void> logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        authService.logout(token);
        return Result.success("登出成功");
    }

    @PostMapping("/change-password")
    @Operation(summary = "修改密码")
    public Result<Void> changePassword(@Valid @RequestBody ChangePasswordRequest request, Authentication authentication) {
        Long userId = (Long) authentication.getPrincipal();
        authService.changePassword(userId, request);
        return Result.success("密码修改成功");
    }

    @PostMapping("/verify-identity")
    @Operation(summary = "实名认证")
    public Result<VerifyIdentityResponse> verifyIdentity(@Valid @RequestBody VerifyIdentityRequest request, Authentication authentication) {
        Long userId = (Long) authentication.getPrincipal();
        VerifyIdentityResponse response = authService.verifyIdentity(userId, request);
        return Result.success(response);
    }

    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip != null && ip.contains(",")) {
            ip = ip.split(",")[0].trim();
        }
        return ip;
    }
}
