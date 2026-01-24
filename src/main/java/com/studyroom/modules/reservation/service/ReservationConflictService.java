package com.studyroom.modules.reservation.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.studyroom.modules.reservation.entity.Reservation;
import com.studyroom.modules.reservation.mapper.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservationConflictService {

    private final ReservationMapper reservationMapper;

    /**
     * 检查座位预约冲突
     */
    public boolean checkConflict(Long seatId, LocalDateTime startTime, LocalDateTime endTime) {
        LambdaQueryWrapper<Reservation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Reservation::getSeatId, seatId);
        wrapper.in(Reservation::getStatus, "PENDING", "CONFIRMED", "IN_USE");
        
        // 检查时间冲突
        // 条件：新预约的开始时间 < 现有预约的结束时间，且新预约的结束时间 > 现有预约的开始时间
        wrapper.and(w -> {
            w.lt(Reservation::getStartTime, endTime)
             .gt(Reservation::getEndTime, startTime);
        });

        return reservationMapper.exists(wrapper);
    }

    /**
     * 检查自习室预约冲突
     */
    public boolean checkRoomConflict(Long roomId, LocalDateTime startTime, LocalDateTime endTime) {
        LambdaQueryWrapper<Reservation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Reservation::getRoomId, roomId);
        wrapper.in(Reservation::getStatus, "PENDING", "CONFIRMED", "IN_USE");
        
        // 检查时间冲突
        wrapper.and(w -> {
            w.lt(Reservation::getStartTime, endTime)
             .gt(Reservation::getEndTime, startTime);
        });

        return reservationMapper.exists(wrapper);
    }

    /**
     * 检查用户预约冲突
     */
    public boolean checkUserConflict(Long userId, LocalDateTime startTime, LocalDateTime endTime) {
        LambdaQueryWrapper<Reservation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Reservation::getUserId, userId);
        wrapper.in(Reservation::getStatus, "PENDING", "CONFIRMED", "IN_USE");
        
        // 检查时间冲突
        wrapper.and(w -> {
            w.lt(Reservation::getStartTime, endTime)
             .gt(Reservation::getEndTime, startTime);
        });

        return reservationMapper.exists(wrapper);
    }
}
