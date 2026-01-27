package com.studyroom.modules.reservation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.studyroom.common.utils.BeanCopyUtils;
import com.studyroom.modules.reservation.dto.request.ReservationCancelRequest;
import com.studyroom.modules.reservation.dto.request.ReservationCheckRequest;
import com.studyroom.modules.reservation.dto.request.ReservationCreateRequest;
import com.studyroom.modules.reservation.dto.request.ReservationQueryRequest;
import com.studyroom.modules.reservation.dto.response.AvailabilityResponse;
import com.studyroom.modules.reservation.entity.Reservation;
import com.studyroom.modules.reservation.mapper.ReservationMapper;
import com.studyroom.modules.reservation.service.ReservationConflictService;
import com.studyroom.modules.reservation.service.ReservationRuleService;
import com.studyroom.modules.reservation.service.ReservationService;
import com.studyroom.modules.reservation.vo.ReservationVO;
import com.studyroom.modules.room.service.SeatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl extends ServiceImpl<ReservationMapper, Reservation> implements ReservationService {

    private final ReservationMapper reservationMapper;
    private final ReservationConflictService reservationConflictService;
    private final ReservationRuleService reservationRuleService;
    private final SeatService seatService;

    @Override
    @Transactional
    public Reservation createReservation(ReservationCreateRequest request, Long userId) {
        // 检查用户预约限制
        if (!checkUserReservationLimit(userId)) {
            throw new RuntimeException("超出预约限制");
        }

        // 检查座位可用性
        AvailabilityResponse availability = checkSeatAvailability(
                request.getRoomId(), request.getSeatId(), 
                request.getStartTime(), request.getEndTime()
        );
        if (!availability.isAvailable()) {
            throw new RuntimeException("座位不可用: " + availability.getReason());
        }

        // 创建预约
        Reservation reservation = BeanCopyUtils.copyBean(request, Reservation.class);
        reservation.setUserId(userId);
        reservation.setStatus("PENDING");
        reservation.setCheckInTime(LocalDateTime.now());
        save(reservation);

        // 占用座位
        seatService.occupySeat(request.getSeatId(), userId, reservation.getId());

        log.info("创建预约成功: {}", reservation.getId());
        return reservation;
    }

    @Override
    @Transactional
    public boolean cancelReservation(ReservationCancelRequest request, Long userId) {
        Reservation reservation = getById(request.getReservationId());
        if (reservation == null) {
            throw new RuntimeException("预约不存在");
        }

        if (!reservation.getUserId().equals(userId)) {
            throw new RuntimeException("无权取消他人预约");
        }

        // 更新预约状态
        reservation.setStatus("CANCELLED");
        reservation.setCancelTime(LocalDateTime.now());
        updateById(reservation);

        // 释放座位
        seatService.releaseSeat(reservation.getSeatId());

        log.info("取消预约成功: {}", reservation.getId());
        return true;
    }

    @Override
    @Transactional
    public boolean checkReservation(ReservationCheckRequest request, Long userId) {
        Reservation reservation = getById(request.getReservationId());
        if (reservation == null) {
            throw new RuntimeException("预约不存在");
        }

        if (!reservation.getUserId().equals(userId)) {
            throw new RuntimeException("无权操作他人预约");
        }

        // 更新预约状态
        reservation.setStatus("CONFIRMED");
        reservation.setCheckInTime(LocalDateTime.now());
        boolean result = updateById(reservation);

        log.info("确认预约成功: {}", reservation.getId());
        return result;
    }

    @Override
    public ReservationVO getReservationDetail(Long id, Long userId) {
        Reservation reservation = getById(id);
        if (reservation == null) {
            throw new RuntimeException("预约不存在");
        }

        if (!reservation.getUserId().equals(userId)) {
            throw new RuntimeException("无权查看他人预约");
        }

        return BeanCopyUtils.copyBean(reservation, ReservationVO.class);
    }

    @Override
    public List<ReservationVO> getUserReservations(ReservationQueryRequest request, Long userId) {
        LambdaQueryWrapper<Reservation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Reservation::getUserId, userId);
        if (request.getStatus() != null) {
            wrapper.eq(Reservation::getStatus, request.getStatus());
        }
        if (request.getRoomId() != null) {
            wrapper.eq(Reservation::getRoomId, request.getRoomId());
        }
        wrapper.orderByDesc(Reservation::getCreateTime);

        List<Reservation> reservations = list(wrapper);
        return BeanCopyUtils.copyBeanList(reservations, ReservationVO.class);
    }

    @Override
    public List<ReservationVO> getReservationList(ReservationQueryRequest request) {
        LambdaQueryWrapper<Reservation> wrapper = new LambdaQueryWrapper<>();
        if (request.getStatus() != null) {
            wrapper.eq(Reservation::getStatus, request.getStatus());
        }
        if (request.getRoomId() != null) {
            wrapper.eq(Reservation::getRoomId, request.getRoomId());
        }
        if (request.getUserId() != null) {
            wrapper.eq(Reservation::getUserId, request.getUserId());
        }
        wrapper.orderByDesc(Reservation::getCreateTime);

        List<Reservation> reservations = list(wrapper);
        return BeanCopyUtils.copyBeanList(reservations, ReservationVO.class);
    }

    @Override
    public AvailabilityResponse checkSeatAvailability(Long roomId, Long seatId, LocalDateTime startTime, LocalDateTime endTime) {
        // 检查时间范围
        if (startTime.isAfter(endTime)) {
            return new AvailabilityResponse(false, "开始时间不能晚于结束时间");
        }

        if (startTime.isBefore(LocalDateTime.now())) {
            return new AvailabilityResponse(false, "不能预约过去的时间");
        }

        // 检查座位是否存在
        if (!seatService.getSeatDetail(seatId).getRoomId().equals(roomId)) {
            return new AvailabilityResponse(false, "座位不属于该自习室");
        }

        // 检查时间冲突
        boolean hasConflict = reservationConflictService.checkConflict(seatId, startTime, endTime);
        if (hasConflict) {
            return new AvailabilityResponse(false, "该时间段已被预约");
        }

        return new AvailabilityResponse(true, "座位可用");
    }

    @Override
    @Transactional
    public boolean updateReservationStatus(Long id, String status) {
        Reservation reservation = getById(id);
        if (reservation == null) {
            throw new RuntimeException("预约不存在");
        }

        reservation.setStatus(status);
        boolean result = updateById(reservation);
        log.info("更新预约状态成功: {}, {}", id, status);
        return result;
    }

    @Override
    public Map<String, Object> getReservationStatistics() {
        // 这里可以实现预约统计逻辑
        // 例如：总预约数、今日预约数、各状态预约数等
        return Map.of(
                "totalReservations", count(),
                "todayReservations", 0,
                "pendingReservations", 0,
                "confirmedReservations", 0,
                "cancelledReservations", 0
        );
    }

    @Override
    @Transactional
    public void cleanupExpiredReservations() {
        // 清理过期预约
        LocalDateTime cutoffTime = LocalDateTime.now().minusHours(2);
        LambdaQueryWrapper<Reservation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Reservation::getStatus, "PENDING");
        wrapper.lt(Reservation::getStartTime, cutoffTime);

        List<Reservation> expiredReservations = list(wrapper);
        for (Reservation reservation : expiredReservations) {
            reservation.setStatus("EXPIRED");
            updateById(reservation);
            seatService.releaseSeat(reservation.getSeatId());
        }

        log.info("清理过期预约成功: {}", expiredReservations.size());
    }

    @Override
    public boolean checkUserReservationLimit(Long userId) {
        // 检查用户今日预约数量
        LocalDateTime today = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        LambdaQueryWrapper<Reservation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Reservation::getUserId, userId);
        wrapper.ge(Reservation::getCreateTime, today);
        wrapper.notIn(Reservation::getStatus, List.of("CANCELLED", "EXPIRED"));

        long count = count(wrapper);
        return count < 10; // 每日最多10个预约
    }

    @Override
    public double calculateReservationFee(ReservationCreateRequest request) {
        // 计算预约费用
        // 这里可以根据实际业务逻辑实现
        long durationMinutes = java.time.Duration.between(request.getStartTime(), request.getEndTime()).toMinutes();
        return durationMinutes * 0.1; // 每分钟0.1元
    }

    @Override
    @Transactional
    public Reservation updateReservation(Long id, ReservationCreateRequest request, Long userId) {
        Reservation reservation = getById(id);
        if (reservation == null) {
            throw new RuntimeException("预约不存在");
        }

        if (!reservation.getUserId().equals(userId)) {
            throw new RuntimeException("无权修改他人预约");
        }

        // 检查座位可用性
        AvailabilityResponse availability = checkSeatAvailability(
                request.getRoomId(), request.getSeatId(), 
                request.getStartTime(), request.getEndTime()
        );
        if (!availability.isAvailable()) {
            throw new RuntimeException("座位不可用: " + availability.getReason());
        }

        // 更新预约
        reservation.setRoomId(request.getRoomId());
        reservation.setSeatId(request.getSeatId());
        reservation.setStartTime(request.getStartTime());
        reservation.setEndTime(request.getEndTime());
//        reservation.setPurpose(request.getPurpose());
        reservation.setUpdateTime(LocalDateTime.now());
        updateById(reservation);

        log.info("更新预约成功: {}", reservation.getId());
        return reservation;
    }

    @Override
    public List<ReservationVO> getUpcomingReservations(Long userId) {
        LocalDateTime now = LocalDateTime.now();
        LambdaQueryWrapper<Reservation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Reservation::getUserId, userId);
        wrapper.eq(Reservation::getStatus, "PENDING");
        wrapper.ge(Reservation::getStartTime, now);
        wrapper.orderByAsc(Reservation::getStartTime);

        List<Reservation> reservations = list(wrapper);
        return BeanCopyUtils.copyBeanList(reservations, ReservationVO.class);
    }

    @Override
    public Map<String, Object> getTodayReservationStatistics() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime today = now.withHour(0).withMinute(0).withSecond(0);
        LocalDateTime tomorrow = today.plusDays(1);

        // 今日总预约数
        LambdaQueryWrapper<Reservation> todayWrapper = new LambdaQueryWrapper<>();
        todayWrapper.ge(Reservation::getCreateTime, today);
        todayWrapper.lt(Reservation::getCreateTime, tomorrow);
        long todayCount = count(todayWrapper);

        // 今日已完成预约数
        LambdaQueryWrapper<Reservation> completedWrapper = new LambdaQueryWrapper<>();
        completedWrapper.ge(Reservation::getCreateTime, today);
        completedWrapper.lt(Reservation::getCreateTime, tomorrow);
        completedWrapper.eq(Reservation::getStatus, "COMPLETED");
        long completedCount = count(completedWrapper);

        // 今日即将开始的预约数
        LambdaQueryWrapper<Reservation> upcomingWrapper = new LambdaQueryWrapper<>();
        upcomingWrapper.eq(Reservation::getStatus, "PENDING");
        upcomingWrapper.ge(Reservation::getStartTime, now);
        upcomingWrapper.lt(Reservation::getStartTime, tomorrow);
        long upcomingCount = count(upcomingWrapper);

        // 今日取消的预约数
        LambdaQueryWrapper<Reservation> cancelledWrapper = new LambdaQueryWrapper<>();
        cancelledWrapper.ge(Reservation::getCreateTime, today);
        cancelledWrapper.lt(Reservation::getCreateTime, tomorrow);
        cancelledWrapper.eq(Reservation::getStatus, "CANCELLED");
        long cancelledCount = count(cancelledWrapper);

        return Map.of(
                "total", todayCount,
                "completed", completedCount,
                "upcoming", upcomingCount,
                "cancelled", cancelledCount
        );
    }
}