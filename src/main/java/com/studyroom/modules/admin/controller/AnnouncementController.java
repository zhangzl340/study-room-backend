package com.studyroom.modules.admin.controller;

import com.studyroom.common.result.Result;
import com.studyroom.modules.admin.dto.request.AnnouncementCreateRequest;
import com.studyroom.modules.admin.service.AnnouncementService;
import com.studyroom.modules.admin.vo.AnnouncementVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/announcements")
@RequiredArgsConstructor
@Tag(name = "公告管理接口", description = "公告的创建、更新、删除等操作")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @PostMapping("/create")
    @Operation(summary = "创建公告")
    public Result<?> createAnnouncement(@RequestBody AnnouncementCreateRequest request) {
        announcementService.createAnnouncement(request);
        return Result.success("创建公告成功");
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "更新公告")
    public Result<?> updateAnnouncement(@PathVariable Long id, @RequestBody AnnouncementCreateRequest request) {
        announcementService.updateAnnouncement(id, request);
        return Result.success("更新公告成功");
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除公告")
    public Result<?> deleteAnnouncement(@PathVariable Long id) {
        announcementService.deleteAnnouncement(id);
        return Result.success("删除公告成功");
    }

    @GetMapping("/detail/{id}")
    @Operation(summary = "获取公告详情")
    public Result<AnnouncementVO> getAnnouncementDetail(@PathVariable Long id) {
        return Result.success(announcementService.getAnnouncementDetail(id));
    }

    @GetMapping("/list")
    @Operation(summary = "获取公告列表")
    public Result<List<AnnouncementVO>> getAnnouncementList(@RequestParam(required = false) Integer page, 
                                                           @RequestParam(required = false) Integer pageSize) {
        return Result.success(announcementService.getAnnouncementList(page, pageSize));
    }

    @PutMapping("/status/{id}")
    @Operation(summary = "更新公告状态")
    public Result<?> updateAnnouncementStatus(@PathVariable Long id, @RequestParam Boolean isActive) {
        announcementService.updateAnnouncementStatus(id, isActive);
        return Result.success("更新公告状态成功");
    }
}
