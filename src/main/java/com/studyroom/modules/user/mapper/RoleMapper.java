package com.studyroom.modules.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.studyroom.modules.user.entity.Admin;
import com.studyroom.modules.user.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}
