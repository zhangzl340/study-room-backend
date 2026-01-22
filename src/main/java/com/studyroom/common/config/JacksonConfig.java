package com.studyroom.common.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.studyroom.common.enums.BaseEnum;
import com.studyroom.common.enums.EnumDeserializer;
import com.studyroom.common.enums.EnumSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Jackson JSON序列化配置
 */
@Configuration
public class JacksonConfig {

    /**
     * 默认日期时间格式
     */
    private static final String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 默认日期格式
     */
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 默认时间格式
     */
    private static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";

    /**
     * 配置Jackson ObjectMapper
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // 注册JavaTime模块
        JavaTimeModule javaTimeModule = new JavaTimeModule();

        // 配置日期时间序列化
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(
                DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_PATTERN)));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(
                DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN)));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(
                DateTimeFormatter.ofPattern(DEFAULT_TIME_PATTERN)));

        // 配置日期时间反序列化
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(
                DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_PATTERN)));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(
                DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN)));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(
                DateTimeFormatter.ofPattern(DEFAULT_TIME_PATTERN)));

        // 注册枚举序列化模块
        SimpleModule enumModule = new SimpleModule();
        enumModule.addSerializer(BaseEnum.class, new EnumSerializer());
        enumModule.addDeserializer(BaseEnum.class, new EnumDeserializer());

        // 注册长整型序列化为字符串（防止前端精度丢失）
        enumModule.addSerializer(Long.class, ToStringSerializer.instance);
        enumModule.addSerializer(BigInteger.class, ToStringSerializer.instance);

        objectMapper.registerModules(javaTimeModule, enumModule);

        // 配置
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        // 设置时区
        objectMapper.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        objectMapper.setLocale(Locale.CHINA);

        return objectMapper;
    }

    /**
     * Jackson构建器自定义配置
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonCustomizer() {
        return builder -> {
            // 设置日期格式
            builder.simpleDateFormat(DEFAULT_DATE_TIME_PATTERN);
            builder.timeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            builder.locale(Locale.CHINA);

            // 配置序列化
            builder.serializers(new EnumSerializer());
            builder.deserializers(new EnumDeserializer());

            // 长整型转字符串
            builder.serializerByType(Long.class, ToStringSerializer.instance);
            builder.serializerByType(Long.TYPE, ToStringSerializer.instance);
            builder.serializerByType(BigInteger.class, ToStringSerializer.instance);

            // 配置Java 8日期时间
            builder.serializers(new LocalDateTimeSerializer(
                    DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_PATTERN)));
            builder.serializers(new LocalDateSerializer(
                    DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN)));
            builder.serializers(new LocalTimeSerializer(
                    DateTimeFormatter.ofPattern(DEFAULT_TIME_PATTERN)));

            builder.deserializers(new LocalDateTimeDeserializer(
                    DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_PATTERN)));
            builder.deserializers(new LocalDateDeserializer(
                    DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN)));
            builder.deserializers(new LocalTimeDeserializer(
                    DateTimeFormatter.ofPattern(DEFAULT_TIME_PATTERN)));
        };
    }

    /**
     * 配置Jackson构建器
     */
    @Bean
    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.simpleDateFormat(DEFAULT_DATE_TIME_PATTERN);
        builder.timeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        builder.locale(Locale.CHINA);
        builder.modules(new JavaTimeModule());
        return builder;
    }
}