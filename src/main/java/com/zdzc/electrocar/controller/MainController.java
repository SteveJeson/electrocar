package com.zdzc.electrocar.controller;

import com.zdzc.electrocar.entity.GPSEntity;
import com.zdzc.electrocar.service.GpsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liuw on 2017/8/29.
 */
@RestController
@RequestMapping("/api")
public class MainController {

    private static Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private GpsService gpsService;

    @RequestMapping("/")
    public String getDemoString() {
        return "nothing";
    }

    @RequestMapping("/gps/{id}")
    public GPSEntity getGPSEntityById(@PathVariable("id") Long id) {
        log.info("======准备查询id为{}的记录========",id);
        return gpsService.findById(id);
    }
}
