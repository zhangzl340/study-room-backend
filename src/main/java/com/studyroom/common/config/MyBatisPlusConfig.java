package com.studyroom.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.core.handlers.MybatisEnumTypeHandler;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
//import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerPlugin;
import com.studyroom.common.enums.BaseEnum;
import com.studyroom.common.enums.BaseEnumTypeHandler;
import com.studyroom.common.handler.CustomMetaObjectHandler;
import com.studyroom.common.handler.MyTenantLineHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis Plus配置
 */
@Configuration
public class MyBatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        // 分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        // 乐观锁插件
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());

        // 多租户插件（如果需要）
        // interceptor.addInnerInterceptor(new TenantLineInnerPlugin(new MyTenantLineHandler()));

        return interceptor;
    }


    /**
     * 自动填充处理器
     */
    @Bean
    public CustomMetaObjectHandler metaObjectHandler() {
        return new CustomMetaObjectHandler();
    }

    /**
     * 枚举类型处理器配置
     * 将BaseEnum枚举存储为code值，读取时自动转换为枚举实例
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> {
            // 设置默认枚举类型处理器
            configuration.setDefaultEnumTypeHandler(BaseEnumTypeHandler.class);
        };
    }
}