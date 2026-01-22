package com.studyroom.common.enums;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.*;

/**
 * 枚举工具类
 */
@Slf4j
public class EnumUtils {

    /**
     * 根据枚举code获取枚举实例
     */
    public static <T extends BaseEnum> T getByCode(Class<T> enumClass, Object code) {
        if (code == null || !enumClass.isEnum()) {
            return null;
        }

        try {
            // 首先尝试调用枚举的静态方法 getByCode
            Method getByCodeMethod = getMethod(enumClass, "getByCode", Object.class);
            if (getByCodeMethod != null) {
                @SuppressWarnings("unchecked")
                T result = (T) getByCodeMethod.invoke(null, code);
                if (result != null) {
                    return result;
                }
            }

            // 遍历枚举常量
            T[] enumConstants = enumClass.getEnumConstants();
            if (enumConstants == null) {
                return null;
            }

            for (T enumConstant : enumConstants) {
                Object enumCode = enumConstant.getCode();
                if (Objects.equals(enumCode, code) ||
                        Objects.equals(String.valueOf(enumCode), String.valueOf(code))) {
                    return enumConstant;
                }
            }
        } catch (Exception e) {
            log.error("获取枚举失败: {}", enumClass.getName(), e);
        }

        return null;
    }

    /**
     * 根据枚举显示名称获取枚举实例
     */
    public static <T extends BaseEnum> T getByName(Class<T> enumClass, String name) {
        if (!StringUtils.hasText(name) || !enumClass.isEnum()) {
            return null;
        }

        try {
            // 首先尝试调用枚举的静态方法 getByName
            Method getByNameMethod = getMethod(enumClass, "getByName", String.class);
            if (getByNameMethod != null) {
                @SuppressWarnings("unchecked")
                T result = (T) getByNameMethod.invoke(null, name);
                if (result != null) {
                    return result;
                }
            }

            // 遍历枚举常量
            T[] enumConstants = enumClass.getEnumConstants();
            if (enumConstants == null) {
                return null;
            }

            for (T enumConstant : enumConstants) {
                String enumName = enumConstant.getName();
                if (name.equalsIgnoreCase(enumName)) {
                    return enumConstant;
                }
            }
        } catch (Exception e) {
            log.error("获取枚举失败: {}", enumClass.getName(), e);
        }

        return null;
    }

    /**
     * 根据枚举常量名获取枚举实例
     */
    public static <T extends BaseEnum> T getByEnumName(Class<T> enumClass, String enumName) {
        if (!StringUtils.hasText(enumName) || !enumClass.isEnum()) {
            return null;
        }

        T[] enumConstants = enumClass.getEnumConstants();
        if (enumConstants == null) {
            return null;
        }

        for (T enumConstant : enumConstants) {
            if (enumConstant.getEnumName().equalsIgnoreCase(enumName)) {
                return enumConstant;
            }
        }

        return null;
    }

    /**
     * 获取所有枚举的code列表
     */
    public static <T extends BaseEnum> List<Object> getCodes(Class<T> enumClass) {
        List<Object> codes = new ArrayList<>();
        if (!enumClass.isEnum()) {
            return codes;
        }

        T[] enumConstants = enumClass.getEnumConstants();
        if (enumConstants == null) {
            return codes;
        }

        for (T enumConstant : enumConstants) {
            codes.add(enumConstant.getCode());
        }

        return codes;
    }

    /**
     * 获取所有枚举的显示名称列表
     */
    public static <T extends BaseEnum> List<String> getNames(Class<T> enumClass) {
        List<String> names = new ArrayList<>();
        if (!enumClass.isEnum()) {
            return names;
        }

        T[] enumConstants = enumClass.getEnumConstants();
        if (enumConstants == null) {
            return names;
        }

        for (T enumConstant : enumConstants) {
            names.add(enumConstant.getName());
        }

        return names;
    }

    /**
     * 获取所有枚举的常量名列表
     */
    public static <T extends BaseEnum> List<String> getEnumNames(Class<T> enumClass) {
        List<String> enumNames = new ArrayList<>();
        if (!enumClass.isEnum()) {
            return enumNames;
        }

        T[] enumConstants = enumClass.getEnumConstants();
        if (enumConstants == null) {
            return enumNames;
        }

        for (T enumConstant : enumConstants) {
            enumNames.add(enumConstant.getEnumName());
        }

        return enumNames;
    }

    /**
     * 获取枚举的Map（code -> 显示名称）
     */
    public static <T extends BaseEnum> Map<Object, String> getCodeNameMap(Class<T> enumClass) {
        Map<Object, String> map = new LinkedHashMap<>();
        if (!enumClass.isEnum()) {
            return map;
        }

        T[] enumConstants = enumClass.getEnumConstants();
        if (enumConstants == null) {
            return map;
        }

        for (T enumConstant : enumConstants) {
            map.put(enumConstant.getCode(), enumConstant.getName());
        }

        return map;
    }

    /**
     * 获取枚举的Map（code -> 常量名）
     */
    public static <T extends BaseEnum> Map<Object, String> getCodeEnumNameMap(Class<T> enumClass) {
        Map<Object, String> map = new LinkedHashMap<>();
        if (!enumClass.isEnum()) {
            return map;
        }

        T[] enumConstants = enumClass.getEnumConstants();
        if (enumConstants == null) {
            return map;
        }

        for (T enumConstant : enumConstants) {
            map.put(enumConstant.getCode(), enumConstant.getEnumName());
        }

        return map;
    }

    /**
     * 获取枚举的Map（常量名 -> 显示名称）
     */
    public static <T extends BaseEnum> Map<String, String> getEnumNameNameMap(Class<T> enumClass) {
        Map<String, String> map = new LinkedHashMap<>();
        if (!enumClass.isEnum()) {
            return map;
        }

        T[] enumConstants = enumClass.getEnumConstants();
        if (enumConstants == null) {
            return map;
        }

        for (T enumConstant : enumConstants) {
            map.put(enumConstant.getEnumName(), enumConstant.getName());
        }

        return map;
    }

    /**
     * 获取枚举的Map（code -> description）
     */
    public static <T extends BaseEnum> Map<Object, String> getCodeDescriptionMap(Class<T> enumClass) {
        Map<Object, String> map = new LinkedHashMap<>();
        if (!enumClass.isEnum()) {
            return map;
        }

        T[] enumConstants = enumClass.getEnumConstants();
        if (enumConstants == null) {
            return map;
        }

        for (T enumConstant : enumConstants) {
            map.put(enumConstant.getCode(), enumConstant.getDescription());
        }

        return map;
    }

    /**
     * 验证code是否有效
     */
    public static <T extends BaseEnum> boolean isValidCode(Class<T> enumClass, Object code) {
        return getByCode(enumClass, code) != null;
    }

    /**
     * 获取枚举的显示文本
     */
    public static <T extends BaseEnum> String getDisplayText(Class<T> enumClass, Object code) {
        T enumInstance = getByCode(enumClass, code);
        if (enumInstance == null) {
            return String.valueOf(code);
        }

        return enumInstance.getName();
    }

    /**
     * 获取方法，包括父类方法
     */
    private static Method getMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        try {
            return clazz.getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
}