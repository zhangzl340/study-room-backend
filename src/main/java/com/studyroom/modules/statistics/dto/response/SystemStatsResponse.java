package com.studyroom.modules.statistics.dto.response;

public class SystemStatsResponse {
    private Integer totalUsers;
    private Integer activeUsers;
    private Integer totalReservations;
    private Integer totalCheckIns;
    private Integer totalViolations;
    private Integer todayReservations;
    private Integer todayCheckIns;
    private Integer todayViolations;
    private Double averageUsageRate;

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

    public Integer getTodayReservations() {
        return todayReservations;
    }

    public void setTodayReservations(Integer todayReservations) {
        this.todayReservations = todayReservations;
    }

    public Integer getTodayCheckIns() {
        return todayCheckIns;
    }

    public void setTodayCheckIns(Integer todayCheckIns) {
        this.todayCheckIns = todayCheckIns;
    }

    public Integer getTodayViolations() {
        return todayViolations;
    }

    public void setTodayViolations(Integer todayViolations) {
        this.todayViolations = todayViolations;
    }

    public Double getAverageUsageRate() {
        return averageUsageRate;
    }

    public void setAverageUsageRate(Double averageUsageRate) {
        this.averageUsageRate = averageUsageRate;
    }
}
