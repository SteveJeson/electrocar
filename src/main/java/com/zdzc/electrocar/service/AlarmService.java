package com.zdzc.electrocar.service;

import com.zdzc.electrocar.dto.AlarmDto;
import com.zdzc.electrocar.entity.AlarmEntity;

import java.util.List;

public interface AlarmService {

    List<AlarmEntity> getAlarmListForDevice(String deviceId, String alarmType);

    List<AlarmDto> copyAlarmEntityToDto(List<AlarmEntity> entities);
}
