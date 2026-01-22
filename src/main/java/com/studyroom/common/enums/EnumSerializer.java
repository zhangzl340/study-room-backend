package com.studyroom.common.enums;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 枚举序列化器
 * 将枚举序列化为其code值
 */
public class EnumSerializer extends JsonSerializer<BaseEnum> {

    @Override
    public void serialize(BaseEnum value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {
        if (value == null) {
            gen.writeNull();
        } else {
            // 将枚举序列化为其code值
            Object code = value.getCode();
            if (code instanceof Integer) {
                gen.writeNumber((Integer) code);
            } else if (code instanceof Long) {
                gen.writeNumber((Long) code);
            } else if (code instanceof String) {
                gen.writeString((String) code);
            } else if (code instanceof Boolean) {
                gen.writeBoolean((Boolean) code);
            } else {
                gen.writeString(code.toString());
            }
        }
    }
}