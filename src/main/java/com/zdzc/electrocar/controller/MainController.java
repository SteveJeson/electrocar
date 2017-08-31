package com.zdzc.electrocar.controller;

import com.zdzc.electrocar.common.Authentication;
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

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/GPSInfo/{deviceId}/{accessToken}")
    public JSONResult getLatestGPSInfoByDeviceId(@PathVariable("deviceId") String deviceId,@PathVariable("accessToken")String token,
                                                 HttpServletRequest request) {
        //TODO token校验通过才进行API调用
        if (Authentication.validateToken(token)) {
            GPSNapshotEntity entity =
                    gpsNapshotService.getLatestGPSInfoListByDeviceId(deviceId);
            if (entity != null) {
                return new JSONResult(true,StatusCode.OK,"获取最新坐标信息成功",gpsNapshotService.copyGPSEntityToDTO(entity));
            } else {
                return new JSONResult(true,StatusCode.EMPTY,"未获取到最新坐标信息",null);
            }
        } else{
            return new JSONResult(false,StatusCode.ACCESS_DENIED,"访问被拒绝",null);
        }

    }

}
