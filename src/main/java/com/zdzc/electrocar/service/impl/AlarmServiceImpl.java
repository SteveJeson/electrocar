package com.zdzc.electrocar.service.impl;

import com.zdzc.electrocar.dto.AlarmDto;
import com.zdzc.electrocar.entity.AlarmEntity;
import com.zdzc.electrocar.mapper.AlarmEntityMapper;
import com.zdzc.electrocar.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlarmServiceImpl implements AlarmService {

    @Autowired
    private AlarmEntityMapper mapper;

    /**
     * 获取设备报警信息
     * @param deviceId  设备号
     * @param alarmType 报警类型 0：未处理 1：已处理
     * @return
     */
    @Override
    public List<AlarmEntity> getAlarmListForDevice(String deviceId, String alarmType) {
        return this.mapper.selectAlarmsForDevice(deviceId, Integer.valueOf(alarmType));
    }

    /**
     * 将Entity类信息复制到Dto类以返回指定信息
     * @param entities
     * @return
     */
    @Override
    public List<AlarmDto> copyAlarmEntityToDto(List<AlarmEntity> entities) {
        if (entities != null && entities.size() > 0) {
            List<AlarmDto> dtos = new ArrayList<>(entities.size());
            for (int i = 0;i < entities.size();i++) {
                AlarmEntity entity = entities.get(i);
                AlarmDto dto = new AlarmDto();
                dto.setDeviceId(entity.getDeviceId());
                //TODO 报警状态解析  车辆状态解析,暂时默认设置为原值
                dto.setAlarmStatus(entity.getAlarmStatus());
                dto.setVehicleStatus(entity.getVehicleStatus());

                dto.setHeight(entity.getHeight());
                dto.setLongitude(entity.getLongitude());
                dto.setLatitude(entity.getLatitude());
                dto.setSpeed(entity.getSpeed());
                dto.setTime(entity.getTime());
                dto.setVendor(entity.getVendor());
                dtos.add(dto);
            }
            return dtos;
        }
        return null;
    }
}
