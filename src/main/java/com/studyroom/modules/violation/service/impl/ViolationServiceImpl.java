package com.studyroom.modules.violation.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.studyroom.common.utils.BeanCopyUtils;
import com.studyroom.modules.violation.dto.request.ViolationHandleRequest;
import com.studyroom.modules.violation.entity.ViolationRecord;
import com.studyroom.modules.violation.mapper.ViolationRecordMapper;
import com.studyroom.modules.violation.service.ViolationService;
import com.studyroom.modules.violation.vo.ViolationRecordVO;
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
public class ViolationServiceImpl extends ServiceImpl<ViolationRecordMapper, ViolationRecord> implements ViolationService {

    private final ViolationRecordMapper violationRecordMapper;

    @Override
    @Transactional
    public ViolationRecord recordViolation(ViolationRecord violationRecord) {
        violationRecord.setStatus("PENDING");
        violationRecord.setRecordTime(LocalDateTime.now());
        save(violationRecord);
        log.info("记录违规成功: {}, 用户: {}", violationRecord.getViolationType(), violationRecord.getUserId());
        return violationRecord;
    }

    @Override
    @Transactional
    public boolean handleViolation(ViolationHandleRequest request, Long adminId) {
        ViolationRecord record = getById(request.getViolationId());
        if (record == null) {
            throw new RuntimeException("违规记录不存在");
        }

        record.setStatus(request.getStatus());
        record.setHandleTime(LocalDateTime.now());
        record.setHandlerId(adminId);
        record.setHandleResult(request.getHandleResult());
        record.setDeductCredit(request.getDeductCredit());
        updateById(record);

        log.info("处理违规成功: {}, 状态: {}", record.getId(), request.getStatus());
        return true;
    }

    @Override
    public ViolationRecordVO getViolationRecordDetail(Long id) {
        ViolationRecord record = getById(id);
        if (record == null) {
            throw new RuntimeException("违规记录不存在");
        }
        return BeanCopyUtils.copyBean(record, ViolationRecordVO.class);
    }

    @Override
    public List<ViolationRecordVO> getUserViolationRecords(Long userId) {
        LambdaQueryWrapper<ViolationRecord> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ViolationRecord::getUserId, userId);
        wrapper.orderByDesc(ViolationRecord::getRecordTime);

        List<ViolationRecord> records = list(wrapper);
        return BeanCopyUtils.copyBeanList(records, ViolationRecordVO.class);
    }

    @Override
    public List<ViolationRecordVO> getViolationRecordList(Map<String, Object> params) {
        // 这里可以实现管理员查询逻辑
        List<ViolationRecord> records = list();
        return BeanCopyUtils.copyBeanList(records, ViolationRecordVO.class);
    }

    @Override
    public Map<String, Object> getViolationStatistics() {
        // 这里可以实现违规统计逻辑
        return Map.of(
                "totalViolations", count(),
                "pendingViolations", 0,
                "handledViolations", 0,
                "todayViolations", 0
        );
    }

    @Override
    public boolean hasUnprocessedViolations(Long userId) {
        LambdaQueryWrapper<ViolationRecord> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ViolationRecord::getUserId, userId);
        wrapper.eq(ViolationRecord::getStatus, "PENDING");
        return count(wrapper) > 0;
    }

    @Override
    public int getUserViolationPoints(Long userId) {
        LambdaQueryWrapper<ViolationRecord> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ViolationRecord::getUserId, userId);
        wrapper.eq(ViolationRecord::getStatus, "CONFIRMED");

        List<ViolationRecord> records = list(wrapper);
        return records.stream()
                .mapToInt(ViolationRecord::getDeductCredit)
                .sum();
    }
}