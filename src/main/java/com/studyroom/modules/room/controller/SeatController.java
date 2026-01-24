package com.studyroom.modules.room.controller;

import com.studyroom.common.result.Result;
import com.studyroom.modules.room.dto.request.SeatImportRequest;
import com.studyroom.modules.room.dto.request.SeatLayoutUpdateRequest;
import com.studyroom.modules.room.entity.Seat;
import com.studyroom.modules.room.service.SeatService;
import com.studyroom.modules.room.vo.SeatVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/seat")
@RequiredArgsConstructor
@Tag(name = "座位接口", description = "查看自习室内座位信息")
public class SeatController {

    private final SeatService seatService;

    @PostMapping("/create")
    @Operation(summary = "创建座位")
    public Result<?> createSeat(@RequestBody Seat seat) {
        seatService.createSeat(seat);
        return Result.success("创建座位成功");
    }

    @PostMapping("/batch-create")
    @Operation(summary = "批量创建座位")
    public Result<?> batchCreateSeats(@RequestBody List<Seat> seats) {
        seatService.batchCreateSeats(seats);
        return Result.success("批量创建座位成功");
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "更新座位")
    public Result<?> updateSeat(@PathVariable Long id, @RequestBody Seat seat) {
        seatService.updateSeat(id, seat);
        return Result.success("更新座位成功");
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除座位")
    public Result<?> deleteSeat(@PathVariable Long id) {
        seatService.deleteSeat(id);
        return Result.success("删除座位成功");
    }

    @GetMapping("/detail/{id}")
    @Operation(summary = "获取座位信息")
    public Result<SeatVO> getSeatDetail(@PathVariable Long id) {
        return Result.success(seatService.getSeatDetail(id));
    }

    @GetMapping("/list/{roomId}")
    @Operation(summary = "根据自习室id获取座位列表")
    public Result<List<SeatVO>> getSeatsByRoomId(@PathVariable Long roomId) {
        return Result.success(seatService.getSeatsByRoomId(roomId));
    }

    @PutMapping("/status/{id}")
    @Operation(summary = "更新座位信息")
    public Result<?> updateSeatStatus(@PathVariable Long id, @RequestParam String status) {
        seatService.updateSeatStatus(id, status);
        return Result.success("更新座位状态成功");
    }

    @GetMapping("/available/{roomId}")
    @Operation(summary = "获取某自习室内可用座位")
    public Result<List<SeatVO>> getAvailableSeats(@PathVariable Long roomId) {
        return Result.success(seatService.getAvailableSeats(roomId));
    }

    @PostMapping("/import")
    @Operation(summary = "导入座位")
    public Result<?> importSeats(@RequestBody SeatImportRequest request) {
        seatService.importSeats(request);
        return Result.success("导入座位成功");
    }

    @PutMapping("/layout")
    @Operation(summary = "更新座位布局")
    public Result<?> updateSeatLayout(@RequestBody SeatLayoutUpdateRequest request) {
        seatService.updateSeatLayout(request);
        return Result.success("更新座位布局成功");
    }

    @GetMapping("/statistics/{roomId}")
    @Operation(summary = "获取自习室内座位统计信息")
    public Result<Map<String, Object>> getSeatStatistics(@PathVariable Long roomId) {
        return Result.success(seatService.getSeatStatistics(roomId));
    }

    @PutMapping("/release/{id}")
    @Operation(summary = "释放座位")
    public Result<?> releaseSeat(@PathVariable Long id) {
        seatService.releaseSeat(id);
        return Result.success("释放座位成功");
    }

    @PutMapping("/occupy/{id}")
    @Operation(summary = "占座")
    public Result<?> occupySeat(@PathVariable Long id, 
                               @RequestParam Long userId, 
                               @RequestParam Long reservationId) {
        seatService.occupySeat(id, userId, reservationId);
        return Result.success("占用座位成功");
    }
}
