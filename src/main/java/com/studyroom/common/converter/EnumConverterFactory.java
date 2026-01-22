package com.studyroom.common.converter;

import com.studyroom.common.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 枚举转换器工厂
 * 用于将请求参数中的字符串转换为枚举类型
 */
public class EnumConverterFactory implements ConverterFactory<String, BaseEnum> {

    private static final Map<Class<?>, Converter<String, ?>> CONVERTER_MAP = new HashMap<>();

    @SuppressWarnings("unchecked")
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        Converter<String, T> converter = (Converter<String, T>) CONVERTER_MAP.get(targetType);
        if (converter == null) {
            converter = new StringToEnumConverter<>(targetType);
            CONVERTER_MAP.put(targetType, converter);
        }
        return converter;
    }

    /**
     * 字符串到枚举的转换器
     */
    private static class StringToEnumConverter<T extends BaseEnum> implements Converter<String, T> {

        private final Class<T> enumType;
        private final Map<String, T> enumMap = new HashMap<>();

        public StringToEnumConverter(Class<T> enumType) {
            this.enumType = enumType;

            // 初始化枚举映射
            T[] enums = enumType.getEnumConstants();
            for (T e : enums) {
                // 获取枚举的code值
                Object code = e.getCode();
                if (code != null) {
                    // 映射code的字符串表示
                    enumMap.put(String.valueOf(code), e);

                    // 如果是字符串类型，也映射原值
                    if (code instanceof String) {
                        String codeStr = (String) code;
                        enumMap.put(codeStr.toLowerCase(), e);
                        enumMap.put(codeStr.toUpperCase(), e);
                    }
                }

                // 映射枚举的显示名称（getName()方法）
                String name = e.getName();
                if (name != null) {
                    enumMap.put(name, e);
                    enumMap.put(name.toLowerCase(), e);
                    enumMap.put(name.toUpperCase(), e);
                }

                // 映射枚举常量名（e.name()）
                String enumName = e.getEnumName();
                enumMap.put(enumName, e);
                enumMap.put(enumName.toLowerCase(), e);
                enumMap.put(enumName.toUpperCase(), e);
            }
        }

        @Override
        public T convert(String source) {
            if (!StringUtils.hasText(source)) {
                return null;
            }

            String trimmedSource = source.trim();

            // 直接查找
            T result = enumMap.get(trimmedSource);
            if (result != null) {
                return result;
            }

            // 尝试查找不区分大小写
            for (Map.Entry<String, T> entry : enumMap.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(trimmedSource)) {
                    return entry.getValue();
                }
            }

            // 尝试使用枚举的getByCode方法
            try {
                Method getByCodeMethod = ReflectionUtils.findMethod(enumType, "getByCode", Object.class);
                if (getByCodeMethod != null) {
                    // 首先尝试原始字符串
                    T enumValue = (T) ReflectionUtils.invokeMethod(getByCodeMethod, null, trimmedSource);
                    if (enumValue != null) {
                        return enumValue;
                    }

                    // 尝试转换为整数
                    try {
                        Integer intValue = Integer.parseInt(trimmedSource);
                        enumValue = (T) ReflectionUtils.invokeMethod(getByCodeMethod, null, intValue);
                        if (enumValue != null) {
                            return enumValue;
                        }
                    } catch (NumberFormatException e) {
                        // 不是整数，继续尝试
                    }

                    // 尝试转换为长整数
                    try {
                        Long longValue = Long.parseLong(trimmedSource);
                        enumValue = (T) ReflectionUtils.invokeMethod(getByCodeMethod, null, longValue);
                        if (enumValue != null) {
                            return enumValue;
                        }
                    } catch (NumberFormatException e) {
                        // 不是长整数
                    }
                }
            } catch (Exception e) {
                // 方法调用失败，继续其他方式
            }

            // 没有找到，返回null（或者可以抛出异常）
            return null;
        }
    }
}