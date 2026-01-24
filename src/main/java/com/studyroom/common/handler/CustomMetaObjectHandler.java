package com.studyroom.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 自定义元对象处理器
 * 用于自动填充创建时间和更新时间
 */

@Component
@Primary
public class CustomMetaObjectHandler implements MetaObjectHandler {

    /**
     * 创建时间字段名
     */
    private static final String CREATE_TIME_FIELD = "createTime";

    /**
     * 更新时间字段名
     */
    private static final String UPDATE_TIME_FIELD = "updateTime";

    /**
     * 逻辑删除字段名
     */
    private static final String DELETED_FIELD = "deleted";

    /**
     * 创建人字段名
     */
    private static final String CREATE_BY_FIELD = "createBy";

    /**
     * 更新人字段名
     */
    private static final String UPDATE_BY_FIELD = "updateBy";

    @Override
    public void insertFill(MetaObject metaObject) {
        // 自动填充创建时间
        if (metaObject.hasSetter(CREATE_TIME_FIELD)) {
            strictInsertFill(metaObject, CREATE_TIME_FIELD, LocalDateTime.class, LocalDateTime.now());
        }

        // 自动填充更新时间
        if (metaObject.hasSetter(UPDATE_TIME_FIELD)) {
            strictInsertFill(metaObject, UPDATE_TIME_FIELD, LocalDateTime.class, LocalDateTime.now());
        }

        // 自动填充逻辑删除字段（如果存在）
        if (metaObject.hasSetter(DELETED_FIELD)) {
            strictInsertFill(metaObject, DELETED_FIELD, Integer.class, 0);
        }


        // 创建人（需要从上下文中获取，这里暂时不实现）
        // 可以在Controller中设置，或者通过ThreadLocal获取当前用户
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 自动填充更新时间
        if (metaObject.hasSetter(UPDATE_TIME_FIELD)) {
            strictUpdateFill(metaObject, UPDATE_TIME_FIELD, LocalDateTime.class, LocalDateTime.now());
        }
    }
}