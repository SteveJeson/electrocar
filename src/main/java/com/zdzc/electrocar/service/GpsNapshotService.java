package com.zdzc.electrocar.service;

import com.zdzc.electrocar.entity.GPSNapshotEntity;

/**
 * Created by liuw on 2017/8/29.
 */
public interface GpsNapshotService {

    /**
     * @param deviceId
     * @return
     */
     GPSNapshotEntity getLatestGPSInfoByDeviceId(String deviceId);
}
