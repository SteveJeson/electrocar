package com.zdzc.electrocar.controller;

import com.zdzc.electrocar.entity.GPSEntity;
import com.zdzc.electrocar.service.GpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liuw on 2017/8/29.
 */
@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private GpsService gpsService;

    @RequestMapping("/")
    public List<GPSEntity> getDemoString() {
        return gpsService.findAll();
    }
}
