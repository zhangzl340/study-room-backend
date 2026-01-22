package com.studyroom.common.converter;

import com.studyroom.common.enums.BaseEnum;
import com.studyroom.common.enums.EnumUtils;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 枚举参数转换器（备用方案）
 * 支持更复杂的转换逻辑
 */
public class EnumParamConverter implements ConditionalGenericConverter {

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return sourceType.getType() == String.class &&
                BaseEnum.class.isAssignableFrom(targetType.getType());
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> pairs = new HashSet<>();
        pairs.add(new ConvertiblePair(String.class, BaseEnum.class));
        return Collections.unmodifiableSet(pairs);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (source == null) {
            return null;
        }

        String sourceString = source.toString().trim();
        if (sourceString.isEmpty()) {
            return null;
        }

        Class<? extends BaseEnum> enumClass = (Class<? extends BaseEnum>) targetType.getType();

        // 尝试使用工具类转换
        BaseEnum result = EnumUtils.getByCode(enumClass, sourceString);
        if (result != null) {
            return result;
        }

        // 尝试按name转换
        result = EnumUtils.getByName(enumClass, sourceString);
        if (result != null) {
            return result;
        }

        // 如果都没有找到，尝试查找不区分大小写
        for (BaseEnum enumValue : enumClass.getEnumConstants()) {
            if (enumValue.getName().equalsIgnoreCase(sourceString) ||
                    enumValue.getEnumName().equalsIgnoreCase(sourceString)) {
                return enumValue;
            }
        }

        // 返回null，让后续验证器处理
        return null;
    }
}