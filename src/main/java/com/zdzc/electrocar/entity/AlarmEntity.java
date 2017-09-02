package com.zdzc.electrocar.entity;

import java.util.Date;

public class AlarmEntity {
    /** ��ϢID */
    private Long id;

    /** �ն��豸�� */
    private String deviceId;

    /** ������־ 4λ */
    private Integer alarmStatus;

    /** �����Ƿ���0����1���ǣ� */
    private Integer alarmHandle;

    /** ״̬ 4λ */
    private Integer vehicleStatus;

    /** ���� ��λ���� */
    private Double longitude;

    /** γ�� ��λ���� */
    private Double latitude;

    /** ���θ߶ȣ���(m) */
    private Double height;

    /** �ٶ�km/h */
    private Double speed;

    /** ���� 0-359������Ϊ 0��˳ʱ�� */
    private Double direction;

    /** GPSʱ��  (GMT+8 ʱ��) */
    private Date time;

    /** ��� km */
    private Double milestone;

    /** ���� L */
    private Double oil;

    /** ��¼���ٶ� km/h */
    private Double speed2;

    /** ��չ�����ź�״̬λ */
    private Integer signalStatus;

    /** IO״̬λ */
    private Integer ioStatus;

    /** ģ���� */
    private String analog;

    /** ����ͨ�������ź�ǿ�� */
    private Integer wiff;

    /** ��λ������ */
    private Integer satelliteNum;

    /** д��ʱ�� */
    private Date createTime;

    /** ��ʶ��1�����ģ� */
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

    public Integer getSignalStatus() {
        return signalStatus;
    }

    public void setSignalStatus(Integer signalStatus) {
        this.signalStatus = signalStatus;
    }

    public Integer getIoStatus() {
        return ioStatus;
    }

    public void setIoStatus(Integer ioStatus) {
        this.ioStatus = ioStatus;
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