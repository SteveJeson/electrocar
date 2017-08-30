package com.zdzc.electrocar.mapper;

import com.zdzc.electrocar.entity.GPSNapshotEntity;
import java.util.List;

public interface GPSNapshotEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GPSNapshotEntity record);

    GPSNapshotEntity selectByPrimaryKey(Long id);

    List<GPSNapshotEntity> selectAll();

    int updateByPrimaryKey(GPSNapshotEntity record);

    GPSNapshotEntity selectLatestGPSInfoByDeviceId(String deviceId);

    List<GPSNapshotEntity> selectLatestGPSListByDeviceId(String deviceId);
}