package com.zdzc.electrocar.service.impl;

import com.zdzc.electrocar.entity.GPSEntity;
import com.zdzc.electrocar.mapper.GPSEntityMapper;
import com.zdzc.electrocar.service.GPSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GPSServiceImpl implements GPSService {

    @Autowired
    private GPSEntityMapper mapper;

    /**
     * 获取某设备指定时间内的坐标信息
     * @param deviceId
     * @return
     */
    @Override
    public List<GPSEntity> getGPSInfoForPeriod(String deviceId, Date beginTime, Date endTime) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("deviceId",deviceId);
        params.put("beginTime",beginTime);
        params.put("endTime",endTime);
        return this.mapper.selectGPSInfoForPeriod(params);
    }
}
