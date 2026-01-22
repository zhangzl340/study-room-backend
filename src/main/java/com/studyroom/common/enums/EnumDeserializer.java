package com.studyroom.common.enums;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.util.ClassUtil;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 枚举反序列化器
 * 根据code值反序列化为枚举实例
 */
public class EnumDeserializer extends JsonDeserializer<BaseEnum> {

    @Override
    public BaseEnum deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {

        // 获取当前字段的Java类型
        Class<?> handlerType = ctxt.getContextualType().getRawClass();

        if (!BaseEnum.class.isAssignableFrom(handlerType)) {
            throw JsonMappingException.from(p,
                    "Cannot deserialize enum: target type does not implement BaseEnum");
        }

        try {
            // 获取json中的值
            Object value = getValue(p);
            if (value == null) {
                return null;
            }

            // 查找枚举的getByCode方法
            Method getByCodeMethod = ReflectionUtils.findMethod(handlerType, "getByCode", Object.class);
            if (getByCodeMethod == null) {
                // 如果没有getByCode方法，使用工具类
                return EnumUtils.getByCode((Class<BaseEnum>) handlerType, value);
            }

            // 调用getByCode方法获取枚举实例
            return (BaseEnum) ReflectionUtils.invokeMethod(getByCodeMethod, null, value);

        } catch (Exception e) {
            throw JsonMappingException.from(p,
                    String.format("Cannot deserialize enum %s: %s",
                            handlerType.getName(), e.getMessage()), e);
        }
    }

    /**
     * 从JsonParser中获取值
     */
    private Object getValue(JsonParser p) throws IOException {
        JsonToken token = p.currentToken();

        if (token == JsonToken.VALUE_NULL) {
            return null;
        } else if (token == JsonToken.VALUE_NUMBER_INT) {
            return p.getIntValue();
        } else if (token == JsonToken.VALUE_NUMBER_FLOAT) {
            return p.getDoubleValue();
        } else if (token == JsonToken.VALUE_STRING) {
            String text = p.getText();
            // 尝试转换为整数
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                // 尝试转换为长整数
                try {
                    return Long.parseLong(text);
                } catch (NumberFormatException e2) {
                    return text;
                }
            }
        } else if (token == JsonToken.VALUE_TRUE || token == JsonToken.VALUE_FALSE) {
            return p.getBooleanValue();
        } else {
            return p.getText();
        }
    }
}