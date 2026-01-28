package com.studyroom.modules.room.controller;

import com.studyroom.common.result.Result;
import com.studyroom.modules.room.dto.request.RoomCreateRequest;
import com.studyroom.modules.room.dto.request.RoomQueryRequest;
import com.studyroom.modules.room.service.RoomService;
import com.studyroom.modules.room.vo.RoomVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/room")
@RequiredArgsConstructor
@Tag(name = "自习室管理接口(管理员可用)", description = "自习室创建更新管理")
public class AdminRoomController {

    private final RoomService roomService;

    @PostMapping("/create")
    @Operation(summary = "创建自习室")
    public Result<?> createRoom(@RequestBody RoomCreateRequest request) {
        roomService.createRoom(request);
        return Result.success("创建自习室成功");
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "更新自习室")
    public Result<?> updateRoom(@PathVariable Long id, @RequestBody RoomCreateRequest request) {
        roomService.updateRoom(id, request);
        return Result.success("更新自习室成功");
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除自习室")
    public Result<?> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return Result.success("删除自习室成功");
    }

    @GetMapping("/detail/{id}")
    @Operation(summary = "获取自习室详情")
    public Result<RoomVO> getRoomDetail(@PathVariable Long id) {
        return Result.success(roomService.getRoomDetail(id));
    }

    @GetMapping("/list")
    @Operation(summary = "获取自习室列表")
    public Result<List<RoomVO>> getRoomList(RoomQueryRequest request) {
        return Result.success(roomService.getRoomList(request));
    }

    @PutMapping("/status/{id}")
    @Operation(summary = "更新自习室状态")
    public Result<?> updateRoomStatus(@PathVariable Long id, @RequestParam Integer status) {
        roomService.updateRoomStatus(id, status);
        return Result.success("更新自习室状态成功");
    }

    @GetMapping("/status/{id}")
    @Operation(summary = "获取自习室状态")
    public Result<Map<String, Object>> getRoomStatus(@PathVariable Long id) {
        return Result.success(roomService.getRoomStatus(id));
    }

    @GetMapping("/available")
    @Operation(summary = "获取可用自习室")
    public Result<List<RoomVO>> getAvailableRooms() {
        return Result.success(roomService.getAvailableRooms());
    }
}
