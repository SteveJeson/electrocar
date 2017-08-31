package com.zdzc.electrocar.service;

import com.zdzc.electrocar.dto.GPSNapshotDto;
import com.zdzc.electrocar.entity.GPSNapshotEntity;

import java.util.List;

/**
 * Created by liuw on 2017/8/29.
 */
public interface GpsNapshotService {

     GPSNapshotEntity getLatestGPSInfoByDeviceId(String deviceId);

     GPSNapshotEntity getLatestGPSInfoListByDeviceId(String deviceId);

     GPSNapshotDto copyGPSEntityToDTO(GPSNapshotEntity entity);
}
