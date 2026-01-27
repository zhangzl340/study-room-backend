package com.studyroom.modules.statistics.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StatisticsVO {
    private Long id;
    private LocalDate snapshotDate;
    private Integer totalUsers;
    private Integer activeUsers;
    private Integer totalReservations;
    private Integer completedReservations;
    private Integer cancelledReservations;
    private Integer totalCheckIns;
    private Integer totalViolations;
    private Double averageUsageRate;
    private Integer peakConcurrentUsers;
    private Integer totalStudyHours;
    private Double averageCreditScore;
    private LocalDateTime createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(LocalDate snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public Integer getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(Integer totalUsers) {
        this.totalUsers = totalUsers;
    }

    public Integer getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(Integer activeUsers) {
        this.activeUsers = activeUsers;
    }

    public Integer getTotalReservations() {
        return totalReservations;
    }

    public void setTotalReservations(Integer totalReservations) {
        this.totalReservations = totalReservations;
    }

    public Integer getCompletedReservations() {
        return completedReservations;
    }

    public void setCompletedReservations(Integer completedReservations) {
        this.completedReservations = completedReservations;
    }

    public Integer getCancelledReservations() {
        return cancelledReservations;
    }

    public void setCancelledReservations(Integer cancelledReservations) {
        this.cancelledReservations = cancelledReservations;
    }

    public Integer getTotalCheckIns() {
        return totalCheckIns;
    }

    public void setTotalCheckIns(Integer totalCheckIns) {
        this.totalCheckIns = totalCheckIns;
    }

    public Integer getTotalViolations() {
        return totalViolations;
    }

    public void setTotalViolations(Integer totalViolations) {
        this.totalViolations = totalViolations;
    }

    public Double getAverageUsageRate() {
        return averageUsageRate;
    }

    public void setAverageUsageRate(Double averageUsageRate) {
        this.averageUsageRate = averageUsageRate;
    }

    public Integer getPeakConcurrentUsers() {
        return peakConcurrentUsers;
    }

    public void setPeakConcurrentUsers(Integer peakConcurrentUsers) {
        this.peakConcurrentUsers = peakConcurrentUsers;
    }

    public Integer getTotalStudyHours() {
        return totalStudyHours;
    }

    public void setTotalStudyHours(Integer totalStudyHours) {
        this.totalStudyHours = totalStudyHours;
    }

    public Double getAverageCreditScore() {
        return averageCreditScore;
    }

    public void setAverageCreditScore(Double averageCreditScore) {
        this.averageCreditScore = averageCreditScore;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
