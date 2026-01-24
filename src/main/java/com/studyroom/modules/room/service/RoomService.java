package com.studyroom.modules.room.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.studyroom.modules.room.dto.request.RoomCreateRequest;
import com.studyroom.modules.room.dto.request.RoomQueryRequest;
import com.studyroom.modules.room.entity.StudyRoom;
import com.studyroom.modules.room.vo.RoomVO;

import java.util.List;
import java.util.Map;

public interface RoomService extends IService<StudyRoom> {

    /**
     * 创建自习室
     */
    StudyRoom createRoom(RoomCreateRequest request);

    /**
     * 更新自习室信息
     */
    StudyRoom updateRoom(Long id, RoomCreateRequest request);

    /**
     * 删除自习室
     */
    boolean deleteRoom(Long id);

    /**
     * 获取自习室详情
     */
    RoomVO getRoomDetail(Long id);

    /**
     * 获取自习室列表
     */
    List<RoomVO> getRoomList(RoomQueryRequest request);

    /**
     * 获取自习室状态
     */
    Map<String, Object> getRoomStatus(Long roomId);

    /**
     * 更新自习室开放状态
     */
    boolean updateRoomStatus(Long id, Integer status);

    /**
     * 获取可用自习室
     */
    List<RoomVO> getAvailableRooms();

    /**
     * 检查自习室是否存在
     */
    boolean existsByRoomCode(String roomCode);

    /**
     * 更新自习室座位数量
     */
    boolean updateRoomSeatCount(Long roomId, Integer totalSeats, Integer availableSeats);
}
