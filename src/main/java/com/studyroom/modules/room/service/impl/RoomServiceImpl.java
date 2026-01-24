package com.studyroom.modules.room.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.studyroom.common.utils.BeanCopyUtils;
import com.studyroom.modules.room.dto.request.RoomCreateRequest;
import com.studyroom.modules.room.dto.request.RoomQueryRequest;
import com.studyroom.modules.room.entity.StudyRoom;
import com.studyroom.modules.room.mapper.RoomMapper;
import com.studyroom.modules.room.service.RoomService;
import com.studyroom.modules.room.vo.RoomVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoomServiceImpl extends ServiceImpl<RoomMapper, StudyRoom> implements RoomService {

    private final RoomMapper roomMapper;

    @Override
    @Transactional
    public StudyRoom createRoom(RoomCreateRequest request) {
        StudyRoom room = BeanCopyUtils.copyBean(request, StudyRoom.class);
        room.setAvailableSeats(request.getTotalSeats());
        room.setOpenStatus(1); // 默认开放
        room.setDeleted(0);
        save(room);
        log.info("创建自习室成功: {}", room.getRoomName());
        return room;
    }

    @Override
    @Transactional
    public StudyRoom updateRoom(Long id, RoomCreateRequest request) {
        StudyRoom room = getById(id);
        if (room == null) {
            throw new RuntimeException("自习室不存在");
        }
        BeanCopyUtils.copyBean(request, room);
        updateById(room);
        log.info("更新自习室成功: {}", room.getRoomName());
        return room;
    }

    @Override
    @Transactional
    public boolean deleteRoom(Long id) {
        boolean result = removeById(id);
        log.info("删除自习室成功: {}", id);
        return result;
    }

    @Override
    public RoomVO getRoomDetail(Long id) {
        StudyRoom room = getById(id);
        if (room == null) {
            throw new RuntimeException("自习室不存在");
        }
        return BeanCopyUtils.copyBean(room, RoomVO.class);
    }

    @Override
    public List<RoomVO> getRoomList(RoomQueryRequest request) {
        LambdaQueryWrapper<StudyRoom> wrapper = new LambdaQueryWrapper<>();
        if (request.getBuilding() != null) {
            wrapper.eq(StudyRoom::getBuilding, request.getBuilding());
        }
        if (request.getFloor() != null) {
            wrapper.eq(StudyRoom::getFloor, request.getFloor());
        }
        if (request.getOpenStatus() != null) {
            wrapper.eq(StudyRoom::getOpenStatus, request.getOpenStatus());
        }
        if (request.getRoomName() != null) {
            wrapper.like(StudyRoom::getRoomName, request.getRoomName());
        }
        wrapper.eq(StudyRoom::getDeleted, 0);
        wrapper.orderByDesc(StudyRoom::getCreateTime);
        
        List<StudyRoom> rooms = list(wrapper);
        return rooms.stream()
                .map(room -> BeanCopyUtils.copyBean(room, RoomVO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Object> getRoomStatus(Long roomId) {
        StudyRoom room = getById(roomId);
        if (room == null) {
            throw new RuntimeException("自习室不存在");
        }
        return Map.of(
                "roomId", room.getId(),
                "roomName", room.getRoomName(),
                "openStatus", room.getOpenStatus(),
                "totalSeats", room.getTotalSeats(),
                "availableSeats", room.getAvailableSeats(),
                "usageRate", room.getTotalSeats() > 0 ? 
                        100 - (room.getAvailableSeats() * 100 / room.getTotalSeats()) : 0
        );
    }

    @Override
    @Transactional
    public boolean updateRoomStatus(Long id, Integer status) {
        StudyRoom room = getById(id);
        if (room == null) {
            throw new RuntimeException("自习室不存在");
        }
        room.setOpenStatus(status);
        return updateById(room);
    }

    @Override
    public List<RoomVO> getAvailableRooms() {
        LambdaQueryWrapper<StudyRoom> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudyRoom::getOpenStatus, 1);
        wrapper.eq(StudyRoom::getDeleted, 0);
        wrapper.orderByDesc(StudyRoom::getCreateTime);
        
        List<StudyRoom> rooms = list(wrapper);
        return rooms.stream()
                .map(room -> BeanCopyUtils.copyBean(room, RoomVO.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByRoomCode(String roomCode) {
        LambdaQueryWrapper<StudyRoom> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StudyRoom::getRoomCode, roomCode);
        wrapper.eq(StudyRoom::getDeleted, 0);
        return count(wrapper) > 0;
    }

    @Override
    @Transactional
    public boolean updateRoomSeatCount(Long roomId, Integer totalSeats, Integer availableSeats) {
        StudyRoom room = getById(roomId);
        if (room == null) {
            throw new RuntimeException("自习室不存在");
        }
        room.setTotalSeats(totalSeats);
        room.setAvailableSeats(availableSeats);
        return updateById(room);
    }
}