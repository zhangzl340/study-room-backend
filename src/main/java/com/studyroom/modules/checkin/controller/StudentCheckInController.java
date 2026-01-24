package com.studyroom.modules.checkin.controller;

import com.studyroom.common.result.Result;
import com.studyroom.modules.checkin.dto.request.CheckInRequest;
import com.studyroom.modules.checkin.dto.request.CheckOutRequest;
import com.studyroom.modules.checkin.dto.request.LeaveRequest;
import com.studyroom.modules.checkin.dto.response.CheckInResponse;
import com.studyroom.modules.checkin.dto.response.QRCodeResponse;
import com.studyroom.modules.checkin.service.CheckInService;
import com.studyroom.modules.checkin.vo.CheckInRecordVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/checkin")
@RequiredArgsConstructor
@Tag(name = "学生签到接口", description = "学生签到签退暂离操作")
public class StudentCheckInController {

    private final CheckInService checkInService;

    @PostMapping("/in")
    @Operation(summary = "签到")
    public Result<CheckInResponse> checkIn(@RequestBody CheckInRequest request, 
                                         @RequestAttribute("userId") Long userId) {
        return Result.success(checkInService.checkIn(request, userId));
    }

    @PostMapping("/out")
    @Operation(summary = "签退")
    public Result<?> checkOut(@RequestBody CheckOutRequest request, 
                             @RequestAttribute("userId") Long userId) {
        checkInService.checkOut(request, userId);
        return Result.success("签退成功");
    }

    @PostMapping("/leave")
    @Operation(summary = "暂离")
    public Result<?> temporaryLeave(@RequestBody LeaveRequest request, 
                                  @RequestAttribute("userId") Long userId) {
        checkInService.temporaryLeave(request, userId);
        return Result.success("暂离成功");
    }

    @PostMapping("/return")
    @Operation(summary = "回来")
    public Result<?> returnFromLeave(@RequestBody LeaveRequest request, 
                                   @RequestAttribute("userId") Long userId) {
        checkInService.returnFromLeave(request, userId);
        return Result.success("回来成功");
    }

    @GetMapping("/detail/{id}")
    @Operation(summary = "获取签到记录详情")
    public Result<CheckInRecordVO> getCheckInRecordDetail(@PathVariable Long id, 
                                                        @RequestAttribute("userId") Long userId) {
        return Result.success(checkInService.getCheckInRecordDetail(id, userId));
    }

    @GetMapping("/list")
    @Operation(summary = "获取用户签到记录")
    public Result<List<CheckInRecordVO>> getUserCheckInRecords(@RequestAttribute("userId") Long userId) {
        return Result.success(checkInService.getUserCheckInRecords(userId));
    }

    @GetMapping("/current")
    @Operation(summary = "获取当前签到信息")
    public Result<CheckInRecordVO> getCurrentCheckIn(@RequestAttribute("userId") Long userId) {
        return Result.success(checkInService.getCurrentCheckIn(userId));
    }

    @GetMapping("/qrcode")
    @Operation(summary = "生成签到二维码")
    public Result<QRCodeResponse> generateCheckInQRCode(@RequestParam Long reservationId, 
                                                      @RequestAttribute("userId") Long userId) {
        return Result.success(checkInService.generateCheckInQRCode(reservationId, userId));
    }

    @PostMapping("/verify-qrcode")
    @Operation(summary = "验证签到二维码")
    public Result<?> verifyCheckInQRCode(@RequestParam String qrCode, 
                                       @RequestAttribute("userId") Long userId) {
        boolean result = checkInService.verifyCheckInQRCode(qrCode, userId);
        return result ? Result.success("二维码验证成功") : Result.error("二维码验证失败");
    }
}
