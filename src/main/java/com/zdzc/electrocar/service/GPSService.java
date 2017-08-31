package com.zdzc.electrocar.service;

import com.zdzc.electrocar.entity.GPSEntity;

import java.util.Date;
import java.util.List;

public interface GPSService {

    List<GPSEntity> getGPSInfoForPeriod(String deviceId, Date beginTime, Date endTime);
}
