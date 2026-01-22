package com.studyroom.common.enums;

import lombok.Getter;

/**
 * 用户角色枚举
 */
@Getter
public enum UserRoleEnum implements StringBaseEnum{

    STUDENT("student", "学生", "普通学生用户"),
    ADMIN("admin", "管理员", "系统管理员"),
    SUPER_ADMIN("super_admin", "超级管理员", "系统超级管理员");

    private final String code;
    private final String name;
    private final String description;

    UserRoleEnum(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    /**
     * 根据code获取枚举
     */
    public static UserRoleEnum getByCode(String code) {
        for (UserRoleEnum role : values()) {
            if (role.getCode().equals(code)) {
                return role;
            }
        }
        return null;
    }

    /**
     * 根据name获取枚举
     */
    public static UserRoleEnum getByName(String name) {
        for (UserRoleEnum role : values()) {
            if (role.getName().equals(name)) {
                return role;
            }
        }
        return null;
    }

    /**
     * 判断是否为管理员角色
     */
    public boolean isAdmin() {
        return this == ADMIN || this == SUPER_ADMIN;
    }

    /**
     * 判断是否为超级管理员
     */
    public boolean isSuperAdmin() {
        return this == SUPER_ADMIN;
    }

    /**
     * 判断是否为普通用户
     */
    public boolean isStudent() {
        return this == STUDENT;
    }

    /**
     * 获取角色等级（数值越大权限越高）
     */
    public int getLevel() {
        return switch (this) {
            case STUDENT -> 1;
            case ADMIN -> 2;
            case SUPER_ADMIN -> 3;
        };
    }

    /**
     * 判断当前角色是否有权限
     */
    public boolean hasPermission(UserRoleEnum requiredRole) {
        return this.getLevel() >= requiredRole.getLevel();
    }
}