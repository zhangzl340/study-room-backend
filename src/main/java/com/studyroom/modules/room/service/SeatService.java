package com.studyroom.modules.room.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.studyroom.modules.room.dto.request.SeatImportRequest;
import com.studyroom.modules.room.dto.request.SeatLayoutUpdateRequest;
import com.studyroom.modules.room.entity.Seat;
import com.studyroom.modules.room.vo.SeatVO;

import java.util.List;
import java.util.Map;

public interface SeatService extends IService<Seat> {

    /**
     * 创建座位
     */
    Seat createSeat(Seat seat);

    /**
     * 批量创建座位
     */
    boolean batchCreateSeats(List<Seat> seats);

    /**
     * 更新座位信息
     */
    Seat updateSeat(Long id, Seat seat);

    /**
     * 删除座位
     */
    boolean deleteSeat(Long id);

    /**
     * 获取座位详情
     */
    SeatVO getSeatDetail(Long id);

    /**
     * 获取自习室座位列表
     */
    List<SeatVO> getSeatsByRoomId(Long roomId);

    /**
     * 获取座位状态
     */
    String getSeatStatus(Long seatId);

    /**
     * 更新座位状态
     */
    boolean updateSeatStatus(Long seatId, String status);

    /**
     * 获取可用座位
     */
    List<SeatVO> getAvailableSeats(Long roomId);

    /**
     * 导入座位
     */
    boolean importSeats(SeatImportRequest request);

    /**
     * 更新座位布局
     */
    boolean updateSeatLayout(SeatLayoutUpdateRequest request);

    /**
     * 获取座位使用统计
     */
    Map<String, Object> getSeatStatistics(Long roomId);

    /**
     * 检查座位是否存在
     */
    boolean existsBySeatCode(Long roomId, String seatCode);

    /**
     * 释放座位
     */
    boolean releaseSeat(Long seatId);

    /**
     * 占用座位
     */
    boolean occupySeat(Long seatId, Long userId, Long reservationId);

    /**
     * 获取座位布局
     */
    Map<String, Object> getSeatLayout(Long roomId);
}
