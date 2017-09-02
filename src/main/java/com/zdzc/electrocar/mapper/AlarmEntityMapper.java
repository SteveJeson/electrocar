package com.zdzc.electrocar.mapper;

import com.zdzc.electrocar.entity.AlarmEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlarmEntityMapper {

    List<AlarmEntity> selectAlarmsForDevice(@Param("deviceId") String deviceId, @Param("alarmType") int alarmType);

}