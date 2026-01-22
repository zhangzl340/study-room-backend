package com.studyroom.common.result;

import com.studyroom.common.exception.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * API响应工具类
 */
public class ApiResult {

    /**
     * 创建成功响应
     */
    public static <T> ResponseEntity<Result<T>> ok() {
        return ResponseEntity.ok(Result.success());
    }

    /**
     * 创建成功响应（带数据）
     */
    public static <T> ResponseEntity<Result<T>> ok(T data) {
        return ResponseEntity.ok(Result.success(data));
    }

    /**
     * 创建成功响应（自定义消息）
     */
    public static <T> ResponseEntity<Result<T>> ok(String message) {
        return ResponseEntity.ok(Result.success(message));
    }

    /**
     * 创建成功响应（带数据和消息）
     */
    public static <T> ResponseEntity<Result<T>> ok(T data, String message) {
        return ResponseEntity.ok(Result.success(data, message));
    }

    /**
     * 创建失败响应
     */
    public static <T> ResponseEntity<Result<T>> fail(String message) {
        return ResponseEntity.ok(Result.error(message));
    }

    /**
     * 创建失败响应（带错误码）
     */
    public static <T> ResponseEntity<Result<T>> fail(Integer code, String message) {
        return ResponseEntity.ok(Result.error(code, message));
    }

    /**
     * 创建失败响应（使用错误码）
     */
    public static <T> ResponseEntity<Result<T>> fail(ErrorCode errorCode) {
        return ResponseEntity.ok(Result.error(errorCode));
    }

    /**
     * 创建响应（自定义状态码）
     */
    public static <T> ResponseEntity<Result<T>> response(HttpStatus status, Result<T> result) {
        return ResponseEntity.status(status).body(result);
    }

    /**
     * 创建响应（自定义状态码和消息）
     */
    public static <T> ResponseEntity<Result<T>> response(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(Result.error(message));
    }
}