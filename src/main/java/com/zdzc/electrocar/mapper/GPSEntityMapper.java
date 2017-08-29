package com.zdzc.electrocar.mapper;

import com.zdzc.electrocar.entity.GPSEntity;
import java.util.List;

public interface GPSEntityMapper {
    int deleteByPrimaryKey(String msgId);

    int insert(GPSEntity record);

    GPSEntity selectByPrimaryKey(String msgId);

    List<GPSEntity> selectAll();

    int updateByPrimaryKey(GPSEntity record);
}