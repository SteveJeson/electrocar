package com.zdzc.electrocar.dto;

import java.util.Date;

public class DeviceAlarmDto {

    /** 消息ID */
    private Long id;

    /** 终端设备号 */
    private String deviceId;

    /** 报警标志 4位 */
    private Integer alarmStatus;

    /** 报警是否处理（0：否；1：是） */
    private Integer alarmHandle;

    /** 状态 4位 */
    private Integer vehicleStatus;

    /** 经度 单位：度 */
    private Double longitude;

    /** 纬度 单位：度 */
    private Double latitude;

    /** GPS时间  (GMT+8 时间) */
    private Date time;

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
        this.deviceId = deviceId;
    }

    public Integer getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(Integer alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public Integer getAlarmHandle() {
        return alarmHandle;
    }

    public void setAlarmHandle(Integer alarmHandle) {
        this.alarmHandle = alarmHandle;
    }

    public Integer getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(Integer vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
