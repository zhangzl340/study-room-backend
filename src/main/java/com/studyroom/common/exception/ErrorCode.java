package com.studyroom.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误码枚举类
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {

    // ================== 通用错误码 ==================
    SUCCESS(200, "操作成功"),
    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "未授权，请先登录"),
    FORBIDDEN(403, "权限不足，禁止访问"),
    NOT_FOUND(404, "请求资源不存在"),
    METHOD_NOT_ALLOWED(405, "请求方法不允许"),
    CONFLICT(409, "资源冲突"),
    TOO_MANY_REQUESTS(429, "请求过于频繁"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    SERVICE_UNAVAILABLE(503, "服务暂时不可用"),

    // ================== 认证相关错误码 ==================
    LOGIN_FAILED(10001, "登录失败，用户名或密码错误"),
    ACCOUNT_DISABLED(10002, "账号已被禁用"),
    ACCOUNT_LOCKED(10003, "账号已被锁定"),
    ACCOUNT_EXPIRED(10004, "账号已过期"),
    CREDENTIALS_EXPIRED(10005, "凭证已过期"),
    TOKEN_EXPIRED(10006, "令牌已过期"),
    TOKEN_INVALID(10007, "令牌无效"),
    CAPTCHA_ERROR(10008, "验证码错误"),
    CAPTCHA_EXPIRED(10009, "验证码已过期"),
    USER_NOT_EXIST(10010, "用户不存在"),
    PASSWORD_ERROR(10011, "密码错误"),
    OLD_PASSWORD_ERROR(10012, "原密码错误"),
    USER_EXISTS(10013, "用户已存在"),
    USER_NOT_FOUND(10015, "用户不存在"),
    USERNAME_ALREADY_EXISTS(10016, "用户名已存在"),
    STUDENT_ID_ALREADY_EXISTS(10017, "学号已存在"),
    EMAIL_ALREADY_EXISTS(10018, "邮箱已被使用"),
    PHONE_ALREADY_EXISTS(10019, "手机号已被使用"),
    PASSWORD_SAME(10020, "新密码不能与旧密码相同"),
    IDENTITY_NOT_VERIFIED(10014, "用户未实名认证"),
    ADMIN_INSERT_ERROR(10015,"创建管理员错误"),
    USER_INSERT_ERROR(10015,"插入用户错误"),
    ADMIN_UPDATE_ERROR(10016,"更新管理员错误"),


    // ================== 业务相关错误码 ==================
    ROOM_NOT_FOUND(20001, "自习室不存在"),
    ROOM_DISABLED(20002, "自习室已关闭"),
    SEAT_NOT_FOUND(20003, "座位不存在"),
    SEAT_UNAVAILABLE(20004, "座位不可用"),
    RESERVATION_NOT_FOUND(20005, "预约不存在"),
    RESERVATION_CONFLICT(20006, "预约时间冲突"),
    RESERVATION_CANNOT_CANCEL(20007, "预约无法取消"),
    RESERVATION_EXPIRED(20008, "预约已过期"),
    CHECK_IN_FAILED(20009, "签到失败"),
    CHECK_IN_ALREADY(20010, "已签到，无需重复操作"),
    CHECK_OUT_ALREADY(20011, "已签退，无需重复操作"),
    NOT_CHECK_IN(20012, "未签到，无法签退"),
    TEMP_LEAVE_NOT_ALLOWED(20013, "不允许暂离"),
    TEMP_LEAVE_ALREADY(20014, "已处于暂离状态"),
    NOT_TEMP_LEAVE(20015, "未暂离，无法返回"),
    CHECK_IN_TIME_EXPIRED(20016, "签到时间已过"),
    CREDIT_NOT_ENOUGH(20017, "信用分不足"),
    VIOLATION_NOT_FOUND(20018, "违规记录不存在"),

    // ================== 系统相关错误码 ==================
    SYSTEM_ERROR(30001, "系统错误"),
    DATABASE_ERROR(30002, "数据库操作失败"),
    REDIS_ERROR(30003, "缓存服务异常"),
    FILE_UPLOAD_ERROR(30004, "文件上传失败"),
    FILE_DOWNLOAD_ERROR(30005, "文件下载失败"),
    EXCEL_EXPORT_ERROR(30006, "Excel导出失败"),
    EXCEL_IMPORT_ERROR(30007, "Excel导入失败"),
    WEBSOCKET_ERROR(30008, "WebSocket连接异常"),
    EMAIL_SEND_ERROR(30009, "邮件发送失败"),
    SMS_SEND_ERROR(30010, "短信发送失败"),

    // ================== 参数校验错误码 ==================
    PARAM_VALIDATION_ERROR(40001, "参数校验失败"),
    PARAM_REQUIRED(40002, "参数不能为空"),
    PARAM_INVALID(40003, "参数格式错误"),
    PARAM_OUT_OF_RANGE(40004, "参数超出范围"),

    // ================== 外部服务错误码 ==================
    EXTERNAL_SERVICE_ERROR(50001, "外部服务异常"),
    FACE_RECOGNITION_ERROR(50002, "人脸识别失败"),
    QRCODE_GENERATE_ERROR(50003, "二维码生成失败"),
    SMS_SERVICE_ERROR(50004, "短信服务异常"),

    // ================== 未知错误码 ==================
    UNKNOWN_ERROR(99999, "未知错误");

    private final Integer code;
    private final String message;

    /**
     * 根据code获取ErrorCode
     */
    public static ErrorCode getByCode(Integer code) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.getCode().equals(code)) {
                return errorCode;
            }
        }
        return UNKNOWN_ERROR;
    }

    /**
     * 判断是否成功
     */
    public boolean isSuccess() {
        return this == SUCCESS;
    }
}