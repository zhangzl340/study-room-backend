package com.studyroom.common.security;

import com.studyroom.common.constant.RedisKeyConstant;
import com.studyroom.common.exception.BusinessException;
import com.studyroom.common.exception.ErrorCode;
import com.studyroom.common.utils.JwtUtils;
import com.studyroom.common.utils.RedisUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final RedisUtils redisUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        log.debug("开始JWT认证，请求路径: {}", request.getRequestURI());
        
        String token = getTokenFromRequest(request);
        log.debug("获取到Token: {}", token != null ? token.substring(0, 20) + "..." : "无");

        if (StringUtils.hasText(token) && jwtUtils.validateToken(token)) {
            log.debug("Token格式有效");
            try {
                // 检查token是否有效（在Redis中存在）
                String tokenKey = RedisKeyConstant.USER_TOKEN_KEY + token;
                boolean hasToken = redisUtils.hasKey(tokenKey);
                log.debug("Redis中是否存在Token: {}", hasToken);
                
                if (!hasToken) {
                    log.debug("Token不存在或已被登出，拒绝认证: {}", token.substring(0, 20) + "...");
                    SecurityContextHolder.clearContext();
                } else {
                    String tokenType = jwtUtils.getTokenType(token);
                    log.debug("Token类型: {}", tokenType);
                    
                    if ("access".equals(tokenType)) {
                        Long userId = jwtUtils.getUserId(token);
                        String username = jwtUtils.getUsername(token);
                        String role = jwtUtils.getRole(token);
                        
                        log.debug("Token解析成功 - 用户ID: {}, 用户名: {}, 角色: {}", userId, username, role);

                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(
                                        userId,
                                        null,
                                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()))
                                );
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);

                        log.debug("用户 {} 已认证，设置权限: ROLE_{}", username, role.toUpperCase());
                        log.debug("当前认证对象: {}", SecurityContextHolder.getContext().getAuthentication());
                    }
                }
            } catch (Exception e) {
                log.error("JWT令牌解析失败", e);
                SecurityContextHolder.clearContext();
            }
        } else {
            log.debug("Token无效或不存在");
        }
        
        log.debug("JWT认证完成，认证状态: {}", SecurityContextHolder.getContext().getAuthentication() != null);

        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
