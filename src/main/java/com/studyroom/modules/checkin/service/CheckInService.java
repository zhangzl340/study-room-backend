package com.studyroom.modules.checkin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.studyroom.modules.checkin.dto.request.CheckInRequest;
import com.studyroom.modules.checkin.dto.request.CheckOutRequest;
import com.studyroom.modules.checkin.dto.request.LeaveRequest;
import com.studyroom.modules.checkin.dto.response.CheckInResponse;
import com.studyroom.modules.checkin.dto.response.QRCodeResponse;
import com.studyroom.modules.checkin.entity.CheckInRecord;
import com.studyroom.modules.checkin.vo.CheckInRecordVO;

import java.util.List;
import java.util.Map;

public interface CheckInService extends IService<CheckInRecord> {

    /**
     * 签到
     */
    CheckInResponse checkIn(CheckInRequest request, Long userId);

    /**
     * 签退
     */
    boolean checkOut(CheckOutRequest request, Long userId);

    /**
     * 暂离
     */
    boolean temporaryLeave(LeaveRequest request, Long userId);

    /**
     * 回来
     */
    boolean returnFromLeave(LeaveRequest request, Long userId);

    /**
     * 获取签到记录详情
     */
    CheckInRecordVO getCheckInRecordDetail(Long id, Long userId);

    /**
     * 获取用户签到记录
     */
    List<CheckInRecordVO> getUserCheckInRecords(Long userId);

    /**
     * 获取签到记录列表（管理员）
     */
    List<CheckInRecordVO> getCheckInRecordList(Map<String, Object> params);

    /**
     * 生成签到二维码
     */
    QRCodeResponse generateCheckInQRCode(Long reservationId, Long userId);

    /**
     * 验证签到二维码
     */
    boolean verifyCheckInQRCode(String qrCode, Long userId);

    /**
     * 获取签到统计
     */
    Map<String, Object> getCheckInStatistics();

    /**
     * 清理超时未签退记录
     */
    void cleanupOverdueCheckIns();

    /**
     * 检查用户是否已签到
     */
    boolean isUserCheckedIn(Long userId);

    /**
     * 获取当前签到信息
     */
    CheckInRecordVO getCurrentCheckIn(Long userId);
}
