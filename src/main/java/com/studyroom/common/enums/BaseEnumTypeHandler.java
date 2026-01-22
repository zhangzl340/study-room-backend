package com.studyroom.common.enums;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义枚举类型处理器
 * 用于处理BaseEnum枚举类型在MyBatis中的存储和读取
 */
@MappedTypes(BaseEnum.class)
@MappedJdbcTypes({JdbcType.INTEGER, JdbcType.VARCHAR, JdbcType.CHAR})
public class BaseEnumTypeHandler<E extends BaseEnum> extends BaseTypeHandler<E> {

    private final Class<E> type;

    public BaseEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType)
            throws SQLException {
        if (parameter == null) {
            ps.setNull(i, jdbcType.TYPE_CODE);
            return;
        }

        Object code = parameter.getCode();
        if (code instanceof Integer) {
            ps.setInt(i, (Integer) code);
        } else if (code instanceof Long) {
            ps.setLong(i, (Long) code);
        } else if (code instanceof String) {
            ps.setString(i, (String) code);
        } else if (code instanceof Boolean) {
            ps.setBoolean(i, (Boolean) code);
        } else {
            ps.setObject(i, code);
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Object value = rs.getObject(columnName);
        if (rs.wasNull()) {
            return null;
        }
        return convertToEnum(value);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Object value = rs.getObject(columnIndex);
        if (rs.wasNull()) {
            return null;
        }
        return convertToEnum(value);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Object value = cs.getObject(columnIndex);
        if (cs.wasNull()) {
            return null;
        }
        return convertToEnum(value);
    }

    /**
     * 将数据库值转换为枚举实例
     */
    private E convertToEnum(Object value) {
        if (value == null) {
            return null;
        }

        // 尝试使用枚举的getByCode方法
        try {
            java.lang.reflect.Method getByCodeMethod = type.getMethod("getByCode", Object.class);
            if (getByCodeMethod != null) {
                return (E) getByCodeMethod.invoke(null, value);
            }
        } catch (Exception e) {
            // 如果getByCode方法不存在或调用失败，使用工具类
        }

        // 使用工具类转换
        return EnumUtils.getByCode(type, value);
    }
}