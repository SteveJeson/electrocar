package com.zdzc.electrocar.entity;

import java.util.Date;

public class GPSEntity {
    private String msgId;

    private String deviceId;

    private String alarmStatus;

    private String status;

    private Double longitude;

    private Double latitude;

    private Double height;

    private Double speed;

    private Double direction;

    private Date time;

    private Double mileage;

    private Double oil;

    private Double speed2;

    private String signalStatus;

    private String ioStatus;

    private String analog;

    private Integer networkSignal;

    private Integer satelliteNumber;

    private Date dbTime;

    private Integer vendor;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId == null ? null : msgId.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
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

    public Integer getNetworkSignal() {
        return networkSignal;
    }

    public void setNetworkSignal(Integer networkSignal) {
        this.networkSignal = networkSignal;
    }

    public Integer getSatelliteNumber() {
        return satelliteNumber;
    }

    public void setSatelliteNumber(Integer satelliteNumber) {
        this.satelliteNumber = satelliteNumber;
    }

    public Date getDbTime() {
        return dbTime;
    }

    public void setDbTime(Date dbTime) {
        this.dbTime = dbTime;
    }

    public Integer getVendor() {
        return vendor;
    }

    public void setVendor(Integer vendor) {
        this.vendor = vendor;
    }
}