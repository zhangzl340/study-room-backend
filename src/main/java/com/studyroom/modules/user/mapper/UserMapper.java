package com.studyroom.modules.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.studyroom.modules.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectByUsername(@Param("username") String username);

    User selectByStudentId(@Param("studentId") String studentId);

    User selectByEmail(@Param("email") String email);

    User selectByPhone(@Param("phone") String phone);
}
