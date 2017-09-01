package com.zdzc.electrocar.controller;

import com.zdzc.electrocar.common.Authentication;
import com.zdzc.electrocar.dto.GPSDto;
import com.zdzc.electrocar.entity.GPSEntity;
import com.zdzc.electrocar.entity.GPSNapshotEntity;
import com.zdzc.electrocar.service.GPSService;
import com.zdzc.electrocar.service.GpsNapshotService;
import com.zdzc.electrocar.util.JSONResult;
import com.zdzc.electrocar.util.StatusCode;
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
public class GPSController {

    @Autowired
    private GpsNapshotService gpsNapshotService;

    @Autowired
    private GPSService gpsService;

    @Autowired
    private Mapper mapper;

    private static Logger log = LoggerFactory.getLogger(GPSController.class);

    /**
     * 获取设备最新坐标信息
     * @param deviceId
     * @param token
     * @return
     */
    @RequestMapping(value="/GPSInfo/{deviceId}/{accessToken}")
    public JSONResult getLatestGPSInfoByDeviceId(@PathVariable("deviceId") String deviceId,
                                                 @PathVariable("accessToken")String token) {
        //TODO token校验通过才进行API调用
        if (Authentication.validateToken(token)) {
            GPSNapshotEntity entity =
                    gpsNapshotService.getLatestGPSInfoListByDeviceId(deviceId);
            if (entity != null) {
                return new JSONResult(true,StatusCode.OK,"获取信息成功",gpsNapshotService.copyGPSEntityToDto(entity));
            } else {
                return new JSONResult(true,StatusCode.EMPTY,"未获取到相关信息",null);
            }
        } else{
            return new JSONResult(false,StatusCode.ACCESS_DENIED,"访问被拒绝",null);
        }
    }

    /**
     * 获取设备指定时间内坐标信息
     * @param request
     * @return
     */
    @RequestMapping(value="/GPSList")
    public JSONResult getGPSListForPeriod(HttpServletRequest request) {
        String token = request.getParameter("token");
        String deviceId = request.getParameter("deviceId");
        String startTime = request.getParameter("beginTime");
        String endTime = request.getParameter("endTime");
        if (Authentication.validateToken(token)) {
            List<GPSEntity> entities =  gpsService.getGPSInfoForPeriod(deviceId, startTime, endTime);
            if (entities != null && entities.size() > 0) {
                List<GPSDto> dtos = gpsService.copyGPSEntityToDto(entities);
                return new JSONResult(true,StatusCode.OK,"获取信息成功",dtos);
            } else {
                return new JSONResult(true,StatusCode.EMPTY,"未获取到相关信息",null);
            }
        } else {
            return new JSONResult(false,StatusCode.ACCESS_DENIED,"访问被拒绝",null);
        }

    }

}
