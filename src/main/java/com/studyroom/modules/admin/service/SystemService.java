package com.studyroom.modules.admin.service;

import com.studyroom.modules.admin.dto.request.SystemSettingsUpdateRequest;
import com.studyroom.modules.admin.dto.request.ReservationRulesUpdateRequest;
import com.studyroom.modules.admin.vo.SystemSettingsVO;
import com.studyroom.modules.admin.vo.ReservationRulesVO;

import java.util.Map;

public interface SystemService {
    SystemSettingsVO getSystemSettings();
    SystemSettingsVO updateSystemSettings(SystemSettingsUpdateRequest request);
    ReservationRulesVO getReservationRules();
    ReservationRulesVO updateReservationRules(ReservationRulesUpdateRequest request);
    Map<String, Object> cleanupExpiredData();
    Map<String, Object> backupData();
}
