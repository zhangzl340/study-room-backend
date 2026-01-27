package com.studyroom.modules.reservation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.studyroom.modules.reservation.dto.request.ReservationCancelRequest;
import com.studyroom.modules.reservation.dto.request.ReservationCheckRequest;
import com.studyroom.modules.reservation.dto.request.ReservationCreateRequest;
import com.studyroom.modules.reservation.dto.request.ReservationQueryRequest;
import com.studyroom.modules.reservation.dto.response.AvailabilityResponse;
import com.studyroom.modules.reservation.entity.Reservation;
import com.studyroom.modules.reservation.vo.ReservationVO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ReservationService extends IService<Reservation> {

    /**
     * 创建预约
     */
    Reservation createReservation(ReservationCreateRequest request, Long userId);

    /**
     * 取消预约
     */
    boolean cancelReservation(ReservationCancelRequest request, Long userId);

    /**
     * 检查预约
     */
    boolean checkReservation(ReservationCheckRequest request, Long userId);

    /**
     * 获取预约详情
     */
    ReservationVO getReservationDetail(Long id, Long userId);

    /**
     * 获取用户预约列表
     */
    List<ReservationVO> getUserReservations(ReservationQueryRequest request, Long userId);

    /**
     * 获取预约列表（管理员）
     */
    List<ReservationVO> getReservationList(ReservationQueryRequest request);

    /**
     * 检查座位可用性
     */
    AvailabilityResponse checkSeatAvailability(Long roomId, Long seatId, LocalDateTime startTime, LocalDateTime endTime);

    /**
     * 更新预约状态
     */
    boolean updateReservationStatus(Long id, String status);

    /**
     * 获取预约统计
     */
    Map<String, Object> getReservationStatistics();

    /**
     * 清理过期预约
     */
    void cleanupExpiredReservations();

    /**
     * 检查用户预约限制
     */
    boolean checkUserReservationLimit(Long userId);

    /**
     * 计算预约费用
     */
    double calculateReservationFee(ReservationCreateRequest request);

    /**
     * 更新预约
     */
    Reservation updateReservation(Long id, ReservationCreateRequest request, Long userId);

    /**
     * 获取即将开始的预约
     */
    List<ReservationVO> getUpcomingReservations(Long userId);

    /**
     * 获取今日预约统计
     */
    Map<String, Object> getTodayReservationStatistics();
}
