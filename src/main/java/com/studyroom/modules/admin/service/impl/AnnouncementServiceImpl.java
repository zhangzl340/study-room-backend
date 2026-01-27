package com.studyroom.modules.admin.service.impl;

import com.studyroom.modules.admin.dto.request.AnnouncementCreateRequest;
import com.studyroom.modules.admin.service.AnnouncementService;
import com.studyroom.modules.admin.vo.AnnouncementVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {

    @Override
    public void createAnnouncement(AnnouncementCreateRequest request) {
        log.info("创建公告: {}", request.getTitle());
        // TODO: 实现具体的创建公告逻辑
    }

    @Override
    public void updateAnnouncement(Long id, AnnouncementCreateRequest request) {
        log.info("更新公告: {} - {}", id, request.getTitle());
        // TODO: 实现具体的更新公告逻辑
    }

    @Override
    public void deleteAnnouncement(Long id) {
        log.info("删除公告: {}", id);
        // TODO: 实现具体的删除公告逻辑
    }

    @Override
    public AnnouncementVO getAnnouncementDetail(Long id) {
        log.info("获取公告详情: {}", id);
        // TODO: 实现具体的获取公告详情逻辑
        AnnouncementVO vo = new AnnouncementVO();
        vo.setId(id);
        vo.setTitle("测试公告");
        vo.setContent("这是一个测试公告内容");
        vo.setType("info");
        vo.setIsActive(true);
        vo.setPublishTime(LocalDateTime.now());
        vo.setPublisher("admin");
        return vo;
    }

    @Override
    public List<AnnouncementVO> getAnnouncementList(Integer page, Integer pageSize) {
        log.info("获取公告列表: page={}, pageSize={}", page, pageSize);
        // TODO: 实现具体的获取公告列表逻辑
        List<AnnouncementVO> list = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            AnnouncementVO vo = new AnnouncementVO();
            vo.setId((long) i);
            vo.setTitle("测试公告 " + i);
            vo.setContent("这是测试公告 " + i + " 的内容");
            vo.setType(i % 3 == 0 ? "important" : i % 2 == 0 ? "warning" : "info");
            vo.setIsActive(i % 2 == 0);
            vo.setPublishTime(LocalDateTime.now().minusDays(i));
            vo.setPublisher("admin");
            list.add(vo);
        }
        return list;
    }

    @Override
    public void updateAnnouncementStatus(Long id, Boolean isActive) {
        log.info("更新公告状态: {} - {}", id, isActive);
        // TODO: 实现具体的更新公告状态逻辑
    }
}
