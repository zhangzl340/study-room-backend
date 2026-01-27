package com.studyroom.modules.room.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.studyroom.common.utils.BeanCopyUtils;
import com.studyroom.modules.room.dto.request.SeatImportRequest;
import com.studyroom.modules.room.dto.request.SeatLayoutUpdateRequest;
import com.studyroom.modules.room.entity.Seat;
import com.studyroom.modules.room.mapper.SeatMapper;
import com.studyroom.modules.room.service.SeatService;
import com.studyroom.modules.room.vo.SeatVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SeatServiceImpl extends ServiceImpl<SeatMapper, Seat> implements SeatService {

    private final SeatMapper seatMapper;

    @Override
    @Transactional
    public Seat createSeat(Seat seat) {
        seat.setStatus("AVAILABLE"); // 默认可用
        seat.setDeleted(0);
        save(seat);
        log.info("创建座位成功: {}", seat.getSeatNumber());
        return seat;
    }

    @Override
    @Transactional
    public boolean batchCreateSeats(List<Seat> seats) {
        boolean result = saveBatch(seats);
        log.info("批量创建座位成功: {}", seats.size());
        return result;
    }

    @Override
    @Transactional
    public Seat updateSeat(Long id, Seat seat) {
        Seat existingSeat = getById(id);
        if (existingSeat == null) {
            throw new RuntimeException("座位不存在");
        }
        BeanCopyUtils.copyBean(seat, existingSeat);
        updateById(existingSeat);
        log.info("更新座位成功: {}", existingSeat.getSeatNumber());
        return existingSeat;
    }

    @Override
    @Transactional
    public boolean deleteSeat(Long id) {
        boolean result = removeById(id);
        log.info("删除座位成功: {}", id);
        return result;
    }

    @Override
    public SeatVO getSeatDetail(Long id) {
        Seat seat = getById(id);
        if (seat == null) {
            throw new RuntimeException("座位不存在");
        }
        return BeanCopyUtils.copyBean(seat, SeatVO.class);
    }

    @Override
    public List<SeatVO> getSeatsByRoomId(Long roomId) {
        LambdaQueryWrapper<Seat> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Seat::getRoomId, roomId);
        wrapper.eq(Seat::getDeleted, 0);
        wrapper.orderByAsc(Seat::getSeatNumber);
        List<Seat> seats = list(wrapper);
        return seats.stream()
                .map(seat -> BeanCopyUtils.copyBean(seat, SeatVO.class))
                .collect(Collectors.toList());
    }

    @Override
    public String getSeatStatus(Long seatId) {
        Seat seat = getById(seatId);
        if (seat == null) {
            throw new RuntimeException("座位不存在");
        }
        return seat.getStatus();
    }

    @Override
    @Transactional
    public boolean updateSeatStatus(Long seatId, String status) {
        Seat seat = getById(seatId);
        if (seat == null) {
            throw new RuntimeException("座位不存在");
        }
        seat.setStatus(status);
        return updateById(seat);
    }

    @Override
    public List<SeatVO> getAvailableSeats(Long roomId) {
        LambdaQueryWrapper<Seat> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Seat::getRoomId, roomId);
        wrapper.eq(Seat::getStatus, "AVAILABLE");
        wrapper.eq(Seat::getDeleted, 0);
        List<Seat> seats = list(wrapper);
        return seats.stream()
                .map(seat -> BeanCopyUtils.copyBean(seat, SeatVO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean importSeats(SeatImportRequest request) {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= request.getRowCount(); i++) {
            for (int j = 1; j <= request.getColCount(); j++) {
                Seat seat = new Seat();
                seat.setRoomId(request.getRoomId());
                seat.setSeatNumber(i + "-" + j);
                seat.setSeatCode("S" + request.getRoomId() + "-" + i + j);
                seat.setSeatType("STANDARD");
                seat.setStatus("AVAILABLE");
                seat.setRowIndex(i);
                seat.setColIndex(j);
                seat.setPositionX(j * 100);
                seat.setPositionY(i * 100);
                seat.setHasPower(1);
                seat.setHasDeskLamp(1);
                seat.setDeleted(0);
                seats.add(seat);
            }
        }
        return batchCreateSeats(seats);
    }

    @Override
    @Transactional
    public boolean updateSeatLayout(SeatLayoutUpdateRequest request) {
        // 这里可以实现座位布局的更新逻辑
        // 例如更新座位的位置信息等
        log.info("更新座位布局成功: {}", request.getRoomId());
        return true;
    }

    @Override
    public Map<String, Object> getSeatStatistics(Long roomId) {
        LambdaQueryWrapper<Seat> totalWrapper = new LambdaQueryWrapper<>();
        totalWrapper.eq(Seat::getRoomId, roomId);
        totalWrapper.eq(Seat::getDeleted, 0);
        Long totalSeats = count(totalWrapper);

        LambdaQueryWrapper<Seat> availableWrapper = new LambdaQueryWrapper<>();
        availableWrapper.eq(Seat::getRoomId, roomId);
        availableWrapper.eq(Seat::getStatus, "AVAILABLE");
        availableWrapper.eq(Seat::getDeleted, 0);
        Long availableSeats = count(availableWrapper);

        Long occupiedSeats = totalSeats - availableSeats;
        double usageRate = totalSeats > 0 ? (double) occupiedSeats / totalSeats * 100 : 0;

        return Map.of(
                "totalSeats", totalSeats,
                "availableSeats", availableSeats,
                "occupiedSeats", occupiedSeats,
                "usageRate", usageRate
        );
    }

    @Override
    public boolean existsBySeatCode(Long roomId, String seatCode) {
        LambdaQueryWrapper<Seat> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Seat::getRoomId, roomId);
        wrapper.eq(Seat::getSeatCode, seatCode);
        wrapper.eq(Seat::getDeleted, 0);
        return count(wrapper) > 0;
    }

    @Override
    @Transactional
    public boolean releaseSeat(Long seatId) {
        Seat seat = getById(seatId);
        if (seat == null) {
            throw new RuntimeException("座位不存在");
        }
        seat.setStatus("AVAILABLE");
        seat.setCurrentUserId(null);
        seat.setCurrentReservationId(null);
        return updateById(seat);
    }

    @Override
    @Transactional
    public boolean occupySeat(Long seatId, Long userId, Long reservationId) {
        Seat seat = getById(seatId);
        if (seat == null) {
            throw new RuntimeException("座位不存在");
        }
        if (!"AVAILABLE".equals(seat.getStatus())) {
            throw new RuntimeException("座位已被占用");
        }
        seat.setStatus("OCCUPIED");
        seat.setCurrentUserId(userId);
        seat.setCurrentReservationId(reservationId);
        return updateById(seat);
    }

    @Override
    public Map<String, Object> getSeatLayout(Long roomId) {
        LambdaQueryWrapper<Seat> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Seat::getRoomId, roomId);
        wrapper.eq(Seat::getDeleted, 0);
        wrapper.orderByAsc(Seat::getRowIndex, Seat::getColIndex);
        List<Seat> seats = list(wrapper);

        return Map.of(
                "roomId", roomId,
                "seats", seats,
                "totalSeats", seats.size()
        );
    }
}