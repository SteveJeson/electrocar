package com.zdzc.electrocar.service;

import com.zdzc.electrocar.dto.AlarmDto;
import com.zdzc.electrocar.dto.DeviceAlarmDto;
import com.zdzc.electrocar.entity.AlarmEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AlarmService {

    List<AlarmEntity> getAlarmListForDevice(String deviceId, String alarmType);

    List<AlarmDto> copyAlarmEntityToDto(List<AlarmEntity> entities);

    void updateAlarmType(String alarmIds, String alarmType);

    Map<String, List<DeviceAlarmDto>> getAlarmsForDevices(String deviceIds, String alarmType);

    Map<String, List<DeviceAlarmDto>> getAlarmsForDevices(String alarmType);

}
