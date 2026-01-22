package com.studyroom.common.enums;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * 枚举基类接口
 * 所有枚举都应实现此接口，以便统一处理
 */
public interface BaseEnum{

    /**
     * 获取枚举code（用于数据库存储和JSON序列化）
     */
    @JsonValue
    Object getCode();

    /**
     * 获取枚举显示名称（用户友好名称）
     */
    String getName();

    /**
     * 获取枚举描述
     */
    default String getDescription() {
        return "";
    }

    /**
     * 获取枚举常量名（Java枚举自带的name()方法）
     * 注意：此方法返回的是枚举定义的常量名，如 "NORMAL"、"STUDENT" 等
     */
    default String getEnumName() {
        // 所有枚举都继承自java.lang.Enum，所以可以安全转换
        if (this instanceof Enum) {
            return ((Enum<?>) this).name();
        }
        return "";
    }

    /**
     * 根据code获取枚举实例（静态方法，由具体枚举实现）
     */
    static <T extends BaseEnum> T getByCode(Class<T> enumClass, Object code) {
        return EnumUtils.getByCode(enumClass, code);
    }

    /**
     * 根据name获取枚举实例（静态方法，由具体枚举实现）
     */
    static <T extends BaseEnum> T getByName(Class<T> enumClass, String name) {
        return EnumUtils.getByName(enumClass, name);
    }

    /**
     * 根据枚举常量名获取枚举实例
     */
    static <T extends BaseEnum> T getByEnumName(Class<T> enumClass, String enumName) {
        T[] enumConstants = enumClass.getEnumConstants();
        if (enumConstants == null) {
            return null;
        }

        for (T enumConstant : enumConstants) {
            if (enumConstant.getEnumName().equals(enumName)) {
                return enumConstant;
            }
        }
        return null;
    }

    /**
     * 获取所有枚举的code-name映射
     */
    static <T extends BaseEnum> Map<Object, String> getCodeNameMap(Class<T> enumClass) {
        return EnumUtils.getCodeNameMap(enumClass);
    }

    /**
     * 获取所有枚举的常量名-name映射
     */
    static <T extends BaseEnum> Map<String, String> getEnumNameNameMap(Class<T> enumClass) {
        Map<String, String> map = new HashMap<>();
        T[] enumConstants = enumClass.getEnumConstants();
        if (enumConstants != null) {
            for (T enumConstant : enumConstants) {
                map.put(enumConstant.getEnumName(), enumConstant.getName());
            }
        }
        return map;
    }
}