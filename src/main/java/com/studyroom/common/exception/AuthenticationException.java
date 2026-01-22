package com.studyroom.common.exception;

/**
 * 认证异常类
 */
public class AuthenticationException extends BusinessException {

    public AuthenticationException(ErrorCode errorCode) {
        super(errorCode);
    }

    public AuthenticationException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public AuthenticationException(Integer code, String message) {
        super(code, message);
    }

    /**
     * 快速创建认证异常
     */
    public static AuthenticationException of(ErrorCode errorCode) {
        return new AuthenticationException(errorCode);
    }
}