package com.zdzc.electrocar.mapper;

import com.zdzc.electrocar.entity.GPSEntity;
import java.util.List;

public interface GPSEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GPSEntity record);

    GPSEntity selectByPrimaryKey(Long id);

    List<GPSEntity> selectAll();

    int updateByPrimaryKey(GPSEntity record);
}