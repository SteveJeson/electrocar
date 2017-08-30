package com.zdzc.electrocar.service;

import com.zdzc.electrocar.entity.GPSEntity;

import java.util.List;

/**
 * Created by liuw on 2017/8/29.
 */
public interface GpsService {

    public List<GPSEntity> findAll();

    public GPSEntity findById(Long id);
}
