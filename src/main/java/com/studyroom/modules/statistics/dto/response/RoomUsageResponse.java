package com.studyroom.modules.statistics.dto.response;

public class RoomUsageResponse {
    private Long roomId;
    private String roomName;
    private Integer totalReservations;
    private Integer completedReservations;
    private Double usageRate;
    private Integer averageStayTime;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

    public Double getUsageRate() {
        return usageRate;
    }

    public void setUsageRate(Double usageRate) {
        this.usageRate = usageRate;
    }

    public Integer getAverageStayTime() {
        return averageStayTime;
    }

    public void setAverageStayTime(Integer averageStayTime) {
        this.averageStayTime = averageStayTime;
    }
}
