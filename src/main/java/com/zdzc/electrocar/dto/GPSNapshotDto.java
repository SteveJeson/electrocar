package com.zdzc.electrocar.dto;

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
    private Double lng;
    /**
     * 纬度
     */
    private Double lat;
    /**
     * 经度(高德)
     */
    private Double olng;
    /**
     * 纬度(高德)
     */
    private Double olat;
    /**
     * 经度(百度)
     */
    private Double blng;
    /**
     * 纬度(百度)
     */
    private Double blat;
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
    private String online;
    /**
     * 里程
     */
    private Double milestone;
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
