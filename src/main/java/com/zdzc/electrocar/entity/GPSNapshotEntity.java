package com.zdzc.electrocar.entity;

import java.util.Date;

public class GPSNapshotEntity {
    private Long id;

    private String deviceId;

    private String alarmStatus;

    private String vehicleStatus;

    private Double longitude;

    private Double latitude;

    private Double height;

    private Double speed;

    private Double direction;

    private Date time;

    private Double milestone;

    private Double oil;

    private Double speed2;

    private String signalStatus;

    private String ioStatus;

    private String analog;

    private Integer wiff;

    private Integer satelliteNum;

    private Date createTime;

    private Integer vendor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(String alarmStatus) {
        this.alarmStatus = alarmStatus == null ? null : alarmStatus.trim();
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus == null ? null : vehicleStatus.trim();
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getDirection() {
        return direction;
    }

    public void setDirection(Double direction) {
        this.direction = direction;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getMilestone() {
        return milestone;
    }

    public void setMilestone(Double milestone) {
        this.milestone = milestone;
    }

    public Double getOil() {
        return oil;
    }

    public void setOil(Double oil) {
        this.oil = oil;
    }

    public Double getSpeed2() {
        return speed2;
    }

    public void setSpeed2(Double speed2) {
        this.speed2 = speed2;
    }

    public String getSignalStatus() {
        return signalStatus;
    }

    public void setSignalStatus(String signalStatus) {
        this.signalStatus = signalStatus == null ? null : signalStatus.trim();
    }

    public String getIoStatus() {
        return ioStatus;
    }

    public void setIoStatus(String ioStatus) {
        this.ioStatus = ioStatus == null ? null : ioStatus.trim();
    }

    public String getAnalog() {
        return analog;
    }

    public void setAnalog(String analog) {
        this.analog = analog == null ? null : analog.trim();
    }

    public Integer getWiff() {
        return wiff;
    }

    public void setWiff(Integer wiff) {
        this.wiff = wiff;
    }

    public Integer getSatelliteNum() {
        return satelliteNum;
    }

    public void setSatelliteNum(Integer satelliteNum) {
        this.satelliteNum = satelliteNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getVendor() {
        return vendor;
    }

    public void setVendor(Integer vendor) {
        this.vendor = vendor;
    }
}