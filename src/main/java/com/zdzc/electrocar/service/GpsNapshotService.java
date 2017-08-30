package com.zdzc.electrocar.service;

import com.zdzc.electrocar.entity.GPSNapshotEntity;

import java.util.List;

/**
 * Created by liuw on 2017/8/29.
 */
public interface GpsNapshotService {

     GPSNapshotEntity getLatestGPSInfoByDeviceId(String deviceId);

     List<GPSNapshotEntity> getLatestGPSInfoListByDeviceId(String deviceId);
}
