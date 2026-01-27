package com.studyroom.modules.admin.service;

import com.studyroom.modules.admin.vo.SystemLogVO;

import java.util.List;
import java.util.Map;

public interface LogService {
    List<SystemLogVO> getSystemLogs(Integer page, Integer pageSize, String level, String startDate, String endDate, String keyword);
    SystemLogVO getLogDetail(Long id);
    Integer cleanupExpiredLogs(Integer days);
    Map<String, Object> getLogStatistics();
}
