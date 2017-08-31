package com.zdzc.electrocar.mapper;

import com.zdzc.electrocar.entity.GPSNapshotEntity;
import java.util.List;

public interface GPSNapshotEntityMapper {

    GPSNapshotEntity selectLatestGPSInfoByDeviceId(String deviceId);

    List<GPSNapshotEntity> selectLatestGPSListByDeviceId(String deviceId);
}