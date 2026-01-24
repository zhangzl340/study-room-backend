package com.studyroom.modules.checkin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.studyroom.common.utils.BeanCopyUtils;
import com.studyroom.modules.checkin.dto.request.CheckInRequest;
import com.studyroom.modules.checkin.dto.request.CheckOutRequest;
import com.studyroom.modules.checkin.dto.request.LeaveRequest;
import com.studyroom.modules.checkin.dto.response.CheckInResponse;
import com.studyroom.modules.checkin.dto.response.QRCodeResponse;
import com.studyroom.modules.checkin.entity.CheckInRecord;
import com.studyroom.modules.checkin.mapper.CheckInRecordMapper;
import com.studyroom.modules.checkin.service.CheckInService;
import com.studyroom.modules.checkin.service.QRCodeService;
import com.studyroom.modules.checkin.vo.CheckInRecordVO;
import com.studyroom.modules.reservation.service.ReservationService;
import com.studyroom.modules.room.service.SeatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckInServiceImpl extends ServiceImpl<CheckInRecordMapper, CheckInRecord> implements CheckInService {

    private final CheckInRecordMapper checkInRecordMapper;
    private final ReservationService reservationService;
    private final SeatService seatService;
    private final QRCodeService qrCodeService;

    @Override
    @Transactional
    public CheckInResponse checkIn(CheckInRequest request, Long userId) {
        // 检查用户是否已签到
        if (isUserCheckedIn(userId)) {
            throw new RuntimeException("您已签到，请勿重复操作");
        }

        // 验证预约
        // 这里可以添加预约验证逻辑

        // 创建签到记录
        CheckInRecord record = new CheckInRecord();
        record.setUserId(userId);
        record.setReservationId(request.getReservationId());
        record.setSeatId(request.getSeatId());
        record.setRoomId(request.getRoomId());
        record.setCheckInTime(LocalDateTime.now());
        record.setStatus("IN_USE");
        record.setCheckInMethod(request.getCheckInMethod());
        save(record);

        // 更新座位状态
        seatService.updateSeatStatus(request.getSeatId(), "IN_USE");

        log.info("用户签到成功: {}, 座位: {}", userId, request.getSeatId());

        CheckInResponse response = new CheckInResponse();
        response.setCheckInTime(record.getCheckInTime());
        response.setSeatId(record.getSeatId());
        response.setRoomId(record.getRoomId());
        response.setCheckInMethod(record.getCheckInMethod());
        return response;
    }

    @Override
    @Transactional
    public boolean checkOut(CheckOutRequest request, Long userId) {
        CheckInRecord record = getById(request.getCheckInId());
        if (record == null) {
            throw new RuntimeException("签到记录不存在");
        }

        if (!record.getUserId().equals(userId)) {
            throw new RuntimeException("无权操作他人签到记录");
        }

        if (!"IN_USE".equals(record.getStatus()) && !"TEMPORARY_LEAVE".equals(record.getStatus())) {
            throw new RuntimeException("当前状态无法签退");
        }

        // 更新签到记录
        record.setCheckOutTime(LocalDateTime.now());
        record.setStatus("COMPLETED");
        int duration = (int) (record.getCheckOutTime().toEpochSecond(java.time.ZoneOffset.UTC) - 
                record.getCheckInTime().toEpochSecond(java.time.ZoneOffset.UTC)) / 60;
        record.setActualDuration(duration);
        updateById(record);

        // 更新座位状态
        seatService.releaseSeat(record.getSeatId());

        log.info("用户签退成功: {}, 座位: {}", userId, record.getSeatId());
        return true;
    }

    @Override
    @Transactional
    public boolean temporaryLeave(LeaveRequest request, Long userId) {
        CheckInRecord record = getById(request.getCheckInId());
        if (record == null) {
            throw new RuntimeException("签到记录不存在");
        }

        if (!record.getUserId().equals(userId)) {
            throw new RuntimeException("无权操作他人签到记录");
        }

        if (!"IN_USE".equals(record.getStatus())) {
            throw new RuntimeException("当前状态无法暂离");
        }

        // 更新签到记录
        record.setStatus("TEMPORARY_LEAVE");
        record.setLeaveTime(LocalDateTime.now());
        record.setMaxLeaveMinutes(request.getMaxLeaveMinutes());
        updateById(record);

        // 更新座位状态
        seatService.updateSeatStatus(record.getSeatId(), "TEMPORARY_LEAVE");

        log.info("用户暂离成功: {}, 座位: {}", userId, record.getSeatId());
        return true;
    }

    @Override
    @Transactional
    public boolean returnFromLeave(LeaveRequest request, Long userId) {
        CheckInRecord record = getById(request.getCheckInId());
        if (record == null) {
            throw new RuntimeException("签到记录不存在");
        }

        if (!record.getUserId().equals(userId)) {
            throw new RuntimeException("无权操作他人签到记录");
        }

        if (!"TEMPORARY_LEAVE".equals(record.getStatus())) {
            throw new RuntimeException("当前状态无法回来");
        }

        // 检查暂离时间是否超时
        if (record.getLeaveTime() != null) {
            int leaveMinutes = (int) (LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC) - 
                    record.getLeaveTime().toEpochSecond(java.time.ZoneOffset.UTC)) / 60;
            if (leaveMinutes > record.getMaxLeaveMinutes()) {
                throw new RuntimeException("暂离时间已超时");
            }
            record.setLeaveDuration(leaveMinutes);
        }

        // 更新签到记录
        record.setStatus("IN_USE");
        record.setReturnTime(LocalDateTime.now());
        updateById(record);

        // 更新座位状态
        seatService.updateSeatStatus(record.getSeatId(), "IN_USE");

        log.info("用户回来成功: {}, 座位: {}", userId, record.getSeatId());
        return true;
    }

    @Override
    public CheckInRecordVO getCheckInRecordDetail(Long id, Long userId) {
        CheckInRecord record = getById(id);
        if (record == null) {
            throw new RuntimeException("签到记录不存在");
        }

        if (!record.getUserId().equals(userId)) {
            throw new RuntimeException("无权查看他人签到记录");
        }

        return BeanCopyUtils.copyBean(record, CheckInRecordVO.class);
    }

    @Override
    public List<CheckInRecordVO> getUserCheckInRecords(Long userId) {
        LambdaQueryWrapper<CheckInRecord> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CheckInRecord::getUserId, userId);
        wrapper.orderByDesc(CheckInRecord::getCheckInTime);

        List<CheckInRecord> records = list(wrapper);
        return BeanCopyUtils.copyBeanList(records, CheckInRecordVO.class);
    }

    @Override
    public List<CheckInRecordVO> getCheckInRecordList(Map<String, Object> params) {
        // 这里可以实现管理员查询逻辑
        List<CheckInRecord> records = list();
        return BeanCopyUtils.copyBeanList(records, CheckInRecordVO.class);
    }

    @Override
    public QRCodeResponse generateCheckInQRCode(Long reservationId, Long userId) {
        String qrCode = UUID.randomUUID().toString();
        // 这里可以将二维码信息存储到Redis中，设置过期时间
        
        QRCodeResponse response = new QRCodeResponse();
        response.setQrCode(qrCode);
        response.setExpireTime(LocalDateTime.now().plusMinutes(30));
        return response;
    }

    @Override
    public boolean verifyCheckInQRCode(String qrCode, Long userId) {
        // 这里可以实现二维码验证逻辑
        return true;
    }

    @Override
    public Map<String, Object> getCheckInStatistics() {
        // 这里可以实现签到统计逻辑
        return Map.of(
                "totalCheckIns", count(),
                "todayCheckIns", 0,
                "ongoingCheckIns", 0,
                "averageDuration", 0
        );
    }

    @Override
    @Transactional
    public void cleanupOverdueCheckIns() {
        LocalDateTime cutoffTime = LocalDateTime.now().minusHours(2);
        LambdaQueryWrapper<CheckInRecord> wrapper = new LambdaQueryWrapper<>();
        wrapper.in(CheckInRecord::getStatus, "IN_USE", "TEMPORARY_LEAVE");
        wrapper.lt(CheckInRecord::getCheckInTime, cutoffTime);

        List<CheckInRecord> overdueRecords = list(wrapper);
        for (CheckInRecord record : overdueRecords) {
            record.setStatus("OVERDUE");
            record.setCheckOutTime(LocalDateTime.now());
            updateById(record);
            seatService.releaseSeat(record.getSeatId());
        }

        log.info("清理超时签到记录成功: {}", overdueRecords.size());
    }

    @Override
    public boolean isUserCheckedIn(Long userId) {
        LambdaQueryWrapper<CheckInRecord> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CheckInRecord::getUserId, userId);
        wrapper.in(CheckInRecord::getStatus, "IN_USE", "TEMPORARY_LEAVE");
        return count(wrapper) > 0;
    }

    @Override
    public CheckInRecordVO getCurrentCheckIn(Long userId) {
        LambdaQueryWrapper<CheckInRecord> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CheckInRecord::getUserId, userId);
        wrapper.in(CheckInRecord::getStatus, "IN_USE", "TEMPORARY_LEAVE");
        wrapper.orderByDesc(CheckInRecord::getCheckInTime);

        CheckInRecord record = getOne(wrapper);
        if (record == null) {
            return null;
        }
        return BeanCopyUtils.copyBean(record, CheckInRecordVO.class);
    }
}