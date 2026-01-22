package com.studyroom.common.enums;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 枚举转换器工厂（用于Spring MVC参数绑定）
 */
public class BaseEnumConverterFactory implements ConverterFactory<String, BaseEnum> {

    private static final Map<Class, Converter> CONVERTER_MAP = new HashMap<>();

    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        Converter<String, T> converter = CONVERTER_MAP.get(targetType);
        if (converter == null) {
            converter = new StringToEnumConverter<>(targetType);
            CONVERTER_MAP.put(targetType, converter);
        }
        return converter;
    }

    /**
     * 字符串转枚举转换器
     */
    private static class StringToEnumConverter<T extends BaseEnum> implements Converter<String, T> {

        private final Class<T> enumType;
        private final Map<String, T> enumMap = new HashMap<>();

        public StringToEnumConverter(Class<T> enumType) {
            this.enumType = enumType;
            T[] enums = enumType.getEnumConstants();
            for (T e : enums) {
                enumMap.put(String.valueOf(e.getCode()), e);
                enumMap.put(e.getName(), e);
                enumMap.put(e.getEnumName(), e);
//                enumMap.put(e.getDescription(), e);
            }
        }

        @Override
        public T convert(String source) {
            if (!StringUtils.hasText(source)) {
                return null;
            }
            return enumMap.get(source.trim());
        }
    }
}