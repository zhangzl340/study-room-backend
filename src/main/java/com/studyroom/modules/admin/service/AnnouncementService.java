package com.studyroom.modules.admin.service;

import com.studyroom.modules.admin.dto.request.AnnouncementCreateRequest;
import com.studyroom.modules.admin.vo.AnnouncementVO;

import java.util.List;

public interface AnnouncementService {
    void createAnnouncement(AnnouncementCreateRequest request);
    void updateAnnouncement(Long id, AnnouncementCreateRequest request);
    void deleteAnnouncement(Long id);
    AnnouncementVO getAnnouncementDetail(Long id);
    List<AnnouncementVO> getAnnouncementList(Integer page, Integer pageSize);
    void updateAnnouncementStatus(Long id, Boolean isActive);
}
