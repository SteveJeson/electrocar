package com.zdzc.electrocar.service.impl;

import com.zdzc.electrocar.common.CommonBusiness;
import com.zdzc.electrocar.dto.GPSDto;
import com.zdzc.electrocar.entity.GPSEntity;
import com.zdzc.electrocar.mapper.GPSEntityMapper;
import com.zdzc.electrocar.service.GPSService;
import com.zdzc.electrocar.util.GPSConvertion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public List<GPSEntity> getGPSInfoForPeriod(String deviceId, String beginTime, String endTime) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("deviceId",deviceId);
        params.put("beginTime",beginTime);
        params.put("endTime",endTime);
        return this.mapper.selectGPSInfoForPeriod(params);
    }

    /**
     * 将Entity类信息复制到Dto特制类以返回指定数据
     * @param entities
     * @return
     */
    @Override
    public List<GPSDto> copyGPSEntityToDto(List<GPSEntity> entities) {
        if (entities != null && entities.size() > 0) {
            List<GPSDto> dtos = new ArrayList<>(entities.size());
            for (int i = 0;i < entities.size();i++) {
                GPSEntity entity = entities.get(i);
                GPSDto dto = new GPSDto();
                dto.setDeviceId(entity.getDeviceId());

                dto.setLng(entity.getLongitude());
                dto.setLat(entity.getLatitude());
                //转换成高德经纬度
                double[] gps = null;
                if (entity.getLongitude() != null && entity.getLatitude() != null) {
                   gps = CommonBusiness.getGaodeGPS(entity.getLongitude(),entity.getLatitude());
                   dto.setOlng(gps[0]);
                   dto.setOlat(gps[1]);
                } else {
                    dto.setOlng(entity.getLongitude());
                    dto.setOlat(entity.getLatitude());
                }

                dto.setTime(entity.getTime());
                dto.setSpeed(entity.getSpeed());
                if (entity.getAlarmStatus() != null) {
                    dto.setAccStatus(CommonBusiness.getAccStatus(entity.getAlarmStatus()));
                } else {
                    dto.setAccStatus(entity.getAlarmStatus());
                }
                dtos.add(dto);
            }
            return dtos;
        }
        return null;
    }
}
