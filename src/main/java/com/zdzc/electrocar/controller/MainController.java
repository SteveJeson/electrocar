package com.zdzc.electrocar.controller;

import com.zdzc.electrocar.dto.GPSNapshotDto;
import com.zdzc.electrocar.entity.GPSNapshotEntity;
import com.zdzc.electrocar.service.GpsNapshotService;
import com.zdzc.electrocar.util.JSONResult;
import com.zdzc.electrocar.util.StatusCode;
import jdk.net.SocketFlow;
import org.dozer.Mapper;
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
@RequestMapping("/bsp/api")
public class MainController {

    @Autowired
    private GpsNapshotService gpsNapshotService;

    @Autowired
    private Mapper mapper;

    private static Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/GPSInfo/{deviceId}")
    public JSONResult getLatestGPSInfoByDeviceId(@PathVariable("deviceId") String deviceId) {
        List<GPSNapshotEntity> entityList =
                gpsNapshotService.getLatestGPSInfoListByDeviceId(deviceId);
        return new JSONResult(entityList,true,StatusCode.OK.get(1),"OK");
//        return new JSONResult(entityList.stream().map(form->mapper.map(form,GPSNapshotDto.class)),true, StatusCode.OK.get(1),"OK");
    }

}
