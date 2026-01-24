package com.studyroom.modules.violation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.studyroom.modules.violation.dto.request.ViolationHandleRequest;
import com.studyroom.modules.violation.dto.response.ViolationRecordResponse;
import com.studyroom.modules.violation.entity.ViolationRecord;
import com.studyroom.modules.violation.vo.ViolationRecordVO;

import java.util.List;
import java.util.Map;

public interface ViolationService extends IService<ViolationRecord> {

    /**
     * 记录违规
     */
    ViolationRecord recordViolation(ViolationRecord violationRecord);

    /**
     * 处理违规
     */
    boolean handleViolation(ViolationHandleRequest request, Long adminId);

    /**
     * 获取违规记录详情
     */
    ViolationRecordVO getViolationRecordDetail(Long id);

    /**
     * 获取用户违规记录
     */
    List<ViolationRecordVO> getUserViolationRecords(Long userId);

    /**
     * 获取违规记录列表（管理员）
     */
    List<ViolationRecordVO> getViolationRecordList(Map<String, Object> params);

    /**
     * 获取违规统计
     */
    Map<String, Object> getViolationStatistics();

    /**
     * 检查用户是否有未处理的违规
     */
    boolean hasUnprocessedViolations(Long userId);

    /**
     * 获取用户违规积分
     */
    int getUserViolationPoints(Long userId);
}
