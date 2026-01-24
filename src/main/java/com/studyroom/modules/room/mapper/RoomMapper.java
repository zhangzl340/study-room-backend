package com.studyroom.modules.room.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.studyroom.modules.room.entity.StudyRoom;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomMapper extends BaseMapper<StudyRoom> {
}
