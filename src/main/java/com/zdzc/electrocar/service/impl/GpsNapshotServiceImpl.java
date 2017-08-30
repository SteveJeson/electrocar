package com.zdzc.electrocar.service.impl;

import com.zdzc.electrocar.entity.GPSNapshotEntity;
import com.zdzc.electrocar.mapper.GPSNapshotEntityMapper;
import com.zdzc.electrocar.service.GpsNapshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuw on 2017/8/29.
 */
@Service
public class GpsNapshotServiceImpl implements GpsNapshotService {

    @Autowired
    private GPSNapshotEntityMapper mapper;

    @Override
    public GPSNapshotEntity getLatestGPSInfoByDeviceId(String deviceId) {
        return this.mapper.selectLatestGPSInfoByDeviceId(deviceId);
    }
}
