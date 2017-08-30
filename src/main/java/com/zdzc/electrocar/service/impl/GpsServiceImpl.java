package com.zdzc.electrocar.service.impl;

import com.zdzc.electrocar.entity.GPSEntity;
import com.zdzc.electrocar.mapper.GPSEntityMapper;
import com.zdzc.electrocar.service.GpsService;
import org.hibernate.annotations.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuw on 2017/8/29.
 */
@Service
public class GpsServiceImpl implements GpsService {

    @Autowired
    private GPSEntityMapper mapper;

    @Override
    public List<GPSEntity> findAll() {
        return this.mapper.selectAll();
    }

    @Override
    public GPSEntity findById(Long id) {
        return this.mapper.selectByPrimaryKey(id);
    }


}
