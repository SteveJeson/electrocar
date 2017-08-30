package com.zdzc.electrocar.mapper;

import com.zdzc.electrocar.entity.AlarmEntity;
import java.util.List;

public interface AlarmEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AlarmEntity record);

    AlarmEntity selectByPrimaryKey(Long id);

    List<AlarmEntity> selectAll();

    int updateByPrimaryKey(AlarmEntity record);
}