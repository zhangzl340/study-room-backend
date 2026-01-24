package com.studyroom.modules.room.controller;

import com.studyroom.common.result.Result;
import com.studyroom.modules.room.service.RoomService;
import com.studyroom.modules.room.service.SeatService;
import com.studyroom.modules.room.vo.RoomVO;
import com.studyroom.modules.room.vo.SeatVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/room")
@RequiredArgsConstructor
@Tag(name = "自习室接口", description = "可以查看自习室信息")
public class RoomController {

    private final RoomService roomService;
    private final SeatService seatService;

    @GetMapping("/detail/{id}")
    @Operation(summary = "获取自习室详情")
    public Result<RoomVO> getRoomDetail(@PathVariable Long id) {
        return Result.success(roomService.getRoomDetail(id));
    }

    @GetMapping("/list")
    @Operation(summary = "获取自习室列表")
    public Result<List<RoomVO>> getRoomList() {
        return Result.success(roomService.getAvailableRooms());
    }

    @GetMapping("/available")
    @Operation(summary = "获取可用自习室")
    public Result<List<RoomVO>> getAvailableRooms() {
        return Result.success(roomService.getAvailableRooms());
    }

    @GetMapping("/status/{id}")
    @Operation(summary = "获取自习室状态")
    public Result<Map<String, Object>> getRoomStatus(@PathVariable Long id) {
        return Result.success(roomService.getRoomStatus(id));
    }

    @GetMapping("/{roomId}/seats")
    @Operation(summary = "获取自习室座位信息")
    public Result<List<SeatVO>> getSeatsByRoomId(@PathVariable Long roomId) {
        return Result.success(seatService.getSeatsByRoomId(roomId));
    }

    @GetMapping("/{roomId}/available-seats")
    @Operation(summary = "获取自习室可用座位")
    public Result<List<SeatVO>> getAvailableSeats(@PathVariable Long roomId) {
        return Result.success(seatService.getAvailableSeats(roomId));
    }

    @GetMapping("/{roomId}/seat-statistics")
    @Operation(summary = "获取自习室统计信息")
    public Result<Map<String, Object>> getSeatStatistics(@PathVariable Long roomId) {
        return Result.success(seatService.getSeatStatistics(roomId));
    }
}
