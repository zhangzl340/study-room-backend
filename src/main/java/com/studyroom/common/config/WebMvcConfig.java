package com.studyroom.common.config;

import com.studyroom.common.converter.EnumConverterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring MVC配置
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 配置资源处理器
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//         配置Swagger UI资源（SpringDoc）
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/")
                .setCachePeriod(0);
// 2. Swagger UI核心资源（适配SpringDoc）
        registry.addResourceHandler("/swagger-ui/**", "/swagger-ui.html", "/swagger-config")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springdoc-openapi-ui/")
                .setCachePeriod(0);
        // 配置Knife4j文档资源
        registry.addResourceHandler("/doc.html")
                .addResourceLocations("classpath:/META-INF/resources/")
                .setCachePeriod(0);

        // 配置上传文件访问路径
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/");
    }

    /**
     * 配置参数转换器
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 注册枚举转换器工厂
        registry.addConverterFactory(new EnumConverterFactory());
    }
}
