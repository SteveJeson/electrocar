package com.zdzc.electrocar.dto;

import org.dozer.Mapping;

import java.io.Serializable;
import java.util.Date;

public class GPSNapshotDto implements Serializable{

    /**
     * 终端设备号
     */
    private String deviceId;
    /**
     * 经度
     */
    @Mapping("longitude")
    private Double lng;
    /**
     * 纬度
     */
    @Mapping("latitude")
    private Double lat;
    /**
     * 经度(高德)
     */
//    private Double olng;
    /**
     * 纬度(高德)
     */
//    private Double olat;
    /**
     * 经度(百度)
     */
//    private Double blng;
    /**
     * 纬度(百度)
     */
//    private Double blat;
    /**
     * 采集时间
     */
    private Date time;
    /**
     * 速度
     */
    private Double speed;
    /**
     * 在线状态
     */
//    private String online;
    /**
     * 里程
     */
    private Double milestone;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }



    public Double getMilestone() {
        return milestone;
    }

    public void setMilestone(Double milestone) {
        this.milestone = milestone;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public String getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(String powerStatus) {
        this.powerStatus = powerStatus;
    }

    public String getFortifyStatus() {
        return fortifyStatus;
    }

    public void setFortifyStatus(String fortifyStatus) {
        this.fortifyStatus = fortifyStatus;
    }

    public String getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(String accStatus) {
        this.accStatus = accStatus;
    }

    /**
     * 电量
     */
    private double power;
    /**
     * 充电状态
     */
    private String powerStatus;
    /**
     * 设防状态
     */
    private String fortifyStatus;
    /**
     * Acc状态
     */
    private String accStatus;
}
