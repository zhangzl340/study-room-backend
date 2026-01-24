package com.studyroom.modules.reservation.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.studyroom.modules.reservation.entity.ReservationRule;
import com.studyroom.modules.reservation.mapper.ReservationRuleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationRuleService extends ServiceImpl<ReservationRuleMapper, ReservationRule> {

    private final ReservationRuleMapper reservationRuleMapper;

    /**
     * 获取预约规则
     */
    public ReservationRule getReservationRule() {
        // 获取默认规则或创建默认规则
        ReservationRule rule = getById(1L);
        if (rule == null) {
            rule = createDefaultRule();
        }
        return rule;
    }

    /**
     * 创建默认规则
     */
    private ReservationRule createDefaultRule() {
        ReservationRule rule = new ReservationRule();
        rule.setMaxReservationHours(4);
        rule.setMinReservationMinutes(30);
        rule.setMaxDailyReservations(5);
        rule.setAdvanceReservationHours(24);
        rule.setCancellationDeadlineMinutes(30);
        rule.setNoShowPenaltyMinutes(120);
        rule.setActive(1);
        save(rule);
        return rule;
    }

    /**
     * 更新预约规则
     */
    public boolean updateReservationRule(ReservationRule rule) {
        return updateById(rule);
    }

    /**
     * 检查预约时间是否符合规则
     */
    public boolean checkReservationTime(int hours, int minutes) {
        ReservationRule rule = getReservationRule();
        int totalMinutes = hours * 60 + minutes;
        return totalMinutes >= rule.getMinReservationMinutes() && 
               totalMinutes <= rule.getMaxReservationHours() * 60;
    }

    /**
     * 检查是否可以取消预约
     */
    public boolean canCancelReservation(int minutesBeforeStart) {
        ReservationRule rule = getReservationRule();
        return minutesBeforeStart >= rule.getCancellationDeadlineMinutes();
    }
}
