package com.studyroom.common.controller;

import com.studyroom.common.enums.*;
import com.studyroom.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试控制器
 * 用于验证枚举配置是否生效
 */
@RestController
@RequestMapping("/test")
@Tag(name = "测试接口", description = "用于测试系统配置的接口")
public class TestController {

    @GetMapping("/enums")
    @Operation(summary = "获取所有枚举列表")
    public Result<Map<String, Object>> getEnums() {
        Map<String, Object> result = new HashMap<>();

        // 用户相关枚举
        result.put("userStatus", BaseEnum.getCodeNameMap(UserStatusEnum.class));
        result.put("userStatusEnumName", BaseEnum.getEnumNameNameMap(UserStatusEnum.class));
        result.put("userRoles", BaseEnum.getCodeNameMap(UserRoleEnum.class));
        result.put("userRolesEnumName", BaseEnum.getEnumNameNameMap(UserRoleEnum.class));
        result.put("identityStatus", BaseEnum.getCodeNameMap(IdentityStatusEnum.class));
        result.put("genders", BaseEnum.getCodeNameMap(GenderEnum.class));

        // 自习室相关枚举
        result.put("roomStatus", BaseEnum.getCodeNameMap(RoomStatusEnum.class));
        result.put("seatTypes", BaseEnum.getCodeNameMap(SeatTypeEnum.class));
        result.put("seatStatus", BaseEnum.getCodeNameMap(SeatStatusEnum.class));

        // 预约相关枚举
        result.put("reservationStatus", BaseEnum.getCodeNameMap(ReservationStatusEnum.class));
        result.put("reservationTypes", BaseEnum.getCodeNameMap(ReservationTypeEnum.class));

        // 签到相关枚举
        result.put("checkInMethods", BaseEnum.getCodeNameMap(CheckInMethodEnum.class));
        result.put("checkInStatus", BaseEnum.getCodeNameMap(CheckInStatusEnum.class));
        result.put("checkInActions", BaseEnum.getCodeNameMap(CheckInActionEnum.class));

        // 违规相关枚举
        result.put("violationTypes", BaseEnum.getCodeNameMap(ViolationTypeEnum.class));
        result.put("violationLevels", BaseEnum.getCodeNameMap(ViolationLevelEnum.class));
        result.put("violationStatus", BaseEnum.getCodeNameMap(ViolationStatusEnum.class));

        // 通知相关枚举
        result.put("notificationTypes", BaseEnum.getCodeNameMap(NotificationTypeEnum.class));
        result.put("notificationPriorities", BaseEnum.getCodeNameMap(NotificationPriorityEnum.class));

        return Result.success(result);
    }

    @PostMapping("/test-enum-param")
    @Operation(summary = "测试枚举参数接收（支持多种格式）")
    public Result<Map<String, Object>> testEnumParam(
            @RequestParam(required = false) UserStatusEnum userStatus,
            @RequestParam(required = false) UserRoleEnum userRole,
            @RequestParam(required = false) SeatStatusEnum seatStatus,
            @RequestParam(required = false) String testType) {

        Map<String, Object> result = new HashMap<>();
        result.put("userStatus", userStatus);
        result.put("userRole", userRole);
        result.put("seatStatus", seatStatus);
        result.put("testType", testType);

        if (userStatus != null) {
            result.put("userStatusCode", userStatus.getCode());
            result.put("userStatusName", userStatus.getName());
            result.put("userStatusEnumName", userStatus.getEnumName());
        }

        if (userRole != null) {
            result.put("userRoleCode", userRole.getCode());
            result.put("userRoleName", userRole.getName());
            result.put("userRoleEnumName", userRole.getEnumName());
        }

        if (seatStatus != null) {
            result.put("seatStatusCode", seatStatus.getCode());
            result.put("seatStatusName", seatStatus.getName());
            result.put("seatStatusEnumName", seatStatus.getEnumName());
        }

        return Result.success(result);
    }

    @PostMapping("/test-enum-body")
    @Operation(summary = "测试枚举JSON序列化")
    public Result<TestEnumRequest> testEnumBody(@RequestBody TestEnumRequest request) {
        return Result.success(request);
    }

    @GetMapping("/test-enum-instance")
    @Operation(summary = "测试枚举实例方法")
    public Result<Map<String, Object>> testEnumInstance() {
        Map<String, Object> result = new HashMap<>();

        // 测试各种获取方式
        UserStatusEnum normal1 = UserStatusEnum.getByCode(1);
        UserStatusEnum normal2 = UserStatusEnum.getByName("正常");
        UserStatusEnum normal3 = BaseEnum.getByEnumName(UserStatusEnum.class, "NORMAL");

        result.put("normalByCode", normal1);
        result.put("normalByName", normal2);
        result.put("normalByEnumName", normal3);
        result.put("allEqual", normal1 == normal2 && normal2 == normal3);

        // 测试枚举常量名
        if (normal1 != null) {
            result.put("enumName", normal1.getEnumName()); // 应该返回 "NORMAL"
            result.put("code", normal1.getCode()); // 应该返回 1
            result.put("name", normal1.getName()); // 应该返回 "正常"
        }

        return Result.success(result);
    }

    /**
     * 测试请求体
     */
    public static class TestEnumRequest {
        private UserStatusEnum userStatus;
        private UserRoleEnum userRole;
        private SeatStatusEnum seatStatus;
        private String otherField;

        // getters and setters
        public UserStatusEnum getUserStatus() {
            return userStatus;
        }

        public void setUserStatus(UserStatusEnum userStatus) {
            this.userStatus = userStatus;
        }

        public UserRoleEnum getUserRole() {
            return userRole;
        }

        public void setUserRole(UserRoleEnum userRole) {
            this.userRole = userRole;
        }

        public SeatStatusEnum getSeatStatus() {
            return seatStatus;
        }

        public void setSeatStatus(SeatStatusEnum seatStatus) {
            this.seatStatus = seatStatus;
        }

        public String getOtherField() {
            return otherField;
        }

        public void setOtherField(String otherField) {
            this.otherField = otherField;
        }
    }
}