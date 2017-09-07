package com.zdzc.electrocar.service.impl;

import com.zdzc.electrocar.dto.AlarmDto;
import com.zdzc.electrocar.dto.DeviceAlarmDto;
import com.zdzc.electrocar.entity.AlarmEntity;
import com.zdzc.electrocar.mapper.AlarmEntityMapper;
import com.zdzc.electrocar.service.AlarmService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    /**
     * 更新报警标识信息
     * @param alarmIds  报警消息主键ID 多个以逗号隔开
     * @param alarmType 报警标识 对应数据库alarm_handle
     */
    @Override
    @Transactional
    public void updateAlarmType(String alarmIds, String alarmType) {
        String[] idArr = StringUtils.split(alarmIds, ",");
        for (String id : idArr) {
            this.mapper.updateAlarmType(Long.valueOf(id), Integer.valueOf(alarmType));
        }
    }

    /**
     * 获取多个设备报警信息
     * @param deviceIds 设备号 多个以逗号隔开
     * @param alarmType 报警标识 默认为0：未处理
     * @return
     */
    @Override
    public Map<String, List<DeviceAlarmDto>> getAlarmsForDevices(String deviceIds, String alarmType) {
        String[] devicedIdArr = StringUtils.split(deviceIds, ",");
        HashMap<String, List<DeviceAlarmDto>> map = new LinkedHashMap<>();
        for (String deviceId : devicedIdArr) {
            List<AlarmEntity> entities = this.getAlarmListForDevice(deviceId, alarmType);
            if (entities != null && entities.size() > 0) {
                List<DeviceAlarmDto> dtoList = this.copyAlarmEntityToDeviceAlarmDto(entities);
                map.put(deviceId, dtoList);
            }
        }
        return map;
    }

    /**
     * 获取所有设备未处理的报警信息
     * @param alarmType
     * @return
     */
    public Map<String, List<DeviceAlarmDto>> getAlarmsForDevices(String alarmType) {
        List<AlarmEntity> entities = this.getAlarmListForDevice(null,alarmType);
        List<DeviceAlarmDto> dtos = this.copyAlarmEntityToDeviceAlarmDto(entities);
        HashMap<String, List<DeviceAlarmDto>> mapList = new LinkedHashMap<>();
        for (DeviceAlarmDto dto : dtos) {
            List<DeviceAlarmDto> dtoList = mapList.get(dto.getDeviceId());
            if (dtoList != null && dtoList.size() > 0) {
                dtoList.add(dto);
            } else {
                List<DeviceAlarmDto> deviceAlarmDtos = new ArrayList<>();
                deviceAlarmDtos.add(dto);
                mapList.put(dto.getDeviceId(), deviceAlarmDtos);
            }
        }
        return mapList;


    }


    /**
     * 复制Entity类信息到dto以返回指定字段信息
     * @param entities
     * @return
     */
    private List<DeviceAlarmDto> copyAlarmEntityToDeviceAlarmDto(List<AlarmEntity> entities) {
        if (entities != null && entities.size() > 0) {
            List<DeviceAlarmDto> dtos = new ArrayList<>(entities.size());
            for (int i = 0;i < entities.size();i++) {
                AlarmEntity entity = entities.get(i);
                DeviceAlarmDto dto = new DeviceAlarmDto();
                dto.setId(entity.getId());
                dto.setDeviceId(entity.getDeviceId());
                //TODO 报警状态解析  车辆状态解析,暂时默认设置为原值
                dto.setAlarmStatus(entity.getAlarmStatus());
                dto.setVehicleStatus(entity.getVehicleStatus());

                dto.setAlarmHandle(entity.getAlarmHandle());
                dto.setLongitude(entity.getLongitude());
                dto.setLatitude(entity.getLatitude());
                dto.setTime(entity.getTime());
                dtos.add(dto);
            }
            return dtos;
        }
        return null;
    }


}
