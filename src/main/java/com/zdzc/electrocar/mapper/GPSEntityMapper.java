package com.zdzc.electrocar.mapper;

import com.zdzc.electrocar.entity.GPSEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface GPSEntityMapper {
    List<GPSEntity> selectGPSInfoForPeriod(HashMap<String, Object> params);
}