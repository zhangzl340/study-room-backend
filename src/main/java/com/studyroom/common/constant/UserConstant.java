package com.studyroom.common.constant;

/**
 * 用户相关常量
 */
public class UserConstant {

    // 用户状态
    public static final Integer USER_STATUS_DISABLED = 0;  // 禁用
    public static final Integer USER_STATUS_NORMAL = 1;    // 正常
    public static final Integer USER_STATUS_LOCKED = 2;    // 锁定

    // 用户角色
    public static final String ROLE_STUDENT = "student";      // 学生
    public static final String ROLE_ADMIN = "admin";          // 管理员
    public static final String ROLE_SUPER_ADMIN = "super_admin"; // 超级管理员

    // 实名认证状态
    public static final Integer IDENTITY_STATUS_UNVERIFIED = 0;  // 未认证
    public static final Integer IDENTITY_STATUS_VERIFIED = 1;    // 已认证
    public static final Integer IDENTITY_STATUS_PENDING = 2;     // 审核中
    public static final Integer IDENTITY_STATUS_FAILED = 3;      // 认证失败

    // 性别
    public static final Integer GENDER_UNKNOWN = 0;  // 未知
    public static final Integer GENDER_MALE = 1;     // 男
    public static final Integer GENDER_FEMALE = 2;   // 女

    // 默认值
    public static final Integer DEFAULT_CREDIT_SCORE = 100;  // 默认信用分
    public static final Integer MAX_CREDIT_SCORE = 200;      // 最高信用分
    public static final Integer MIN_CREDIT_SCORE = 0;        // 最低信用分

    // 用户默认头像
    public static final String DEFAULT_AVATAR = "/static/images/default-avatar.png";

    // 密码加密盐值长度
    public static final Integer SALT_LENGTH = 8;

    // 登录相关
    public static final Integer MAX_LOGIN_ATTEMPTS = 5;      // 最大登录尝试次数
    public static final Integer LOGIN_LOCK_TIME = 30;        // 登录锁定时间（分钟）

    // 分页默认值
    public static final Integer DEFAULT_PAGE_SIZE = 20;
    public static final Integer DEFAULT_PAGE_NUMBER = 1;

    // 用户类型
    public static final String USER_TYPE_STUDENT = "STUDENT";
    public static final String USER_TYPE_ADMIN = "ADMIN";

    // 缓存相关
    public static final String CACHE_USER_INFO_PREFIX = "user:info:";
    public static final Long CACHE_USER_INFO_TTL = 3600L;  // 1小时
}