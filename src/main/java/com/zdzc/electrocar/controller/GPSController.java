package com.zdzc.electrocar.controller;

import com.alibaba.fastjson.JSONObject;
import com.zdzc.electrocar.common.Authentication;
import com.zdzc.electrocar.dto.AlarmDto;
import com.zdzc.electrocar.dto.DeviceAlarmDto;
import com.zdzc.electrocar.dto.GPSDto;
import com.zdzc.electrocar.entity.AlarmEntity;
import com.zdzc.electrocar.entity.CommandEntity;
import com.zdzc.electrocar.entity.GPSEntity;
import com.zdzc.electrocar.entity.GPSNapshotEntity;
import com.zdzc.electrocar.service.AlarmService;
import com.zdzc.electrocar.service.GPSService;
import com.zdzc.electrocar.service.GpsNapshotService;
import com.zdzc.electrocar.util.Command;
import com.zdzc.electrocar.util.JSONResult;
import com.zdzc.electrocar.util.StatusCode;
import com.zdzc.electrocar.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

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
    private AlarmService alarmService;

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
                return new JSONResult(true,StatusCode.FAILURE,"未获取到相关信息",null);
            }
        } else{
            return new JSONResult(false,StatusCode.FAILURE,"访问被拒绝",null);
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
                return new JSONResult(true,StatusCode.FAILURE,"未获取到相关信息",null);
            }
        } else {
            return new JSONResult(false,StatusCode.FAILURE,"访问被拒绝",null);
        }

    }

    /**
     * 获取单个设备报警信息
     * @param deviceId
     * @param alarmType
     * @return
     */
    @RequestMapping(value="/alarms/{deviceId}/{alarmType}/{token}")
    public JSONResult getAlarmListForDevice(@PathVariable("deviceId") String deviceId,
                                            @PathVariable("alarmType") String alarmType,
                                            @PathVariable("token") String token) {
        if (Authentication.validateToken(token)) {
            List<AlarmEntity> entities = alarmService.getAlarmListForDevice(deviceId, alarmType);
            if (entities != null && entities.size() > 0) {
                List<AlarmDto> dtos = alarmService.copyAlarmEntityToDto(entities);
                return new JSONResult(true, StatusCode.OK, "获取信息成功",dtos);
            } else {
                return new JSONResult(true, StatusCode.FAILURE, "未获取到相关信息", null);
            }
        } else {
            return new JSONResult(false, StatusCode.FAILURE,"访问被拒绝",null);
        }

    }

    /**
     * 更新报警标识信息
     * @param alarmIds  报警消息主键id，多个以逗号分开
     * @param alarmType 报警标识即报警类型
     * @return
     */
    @PostMapping(value = "/alarms/update")
    public JSONResult updateAlarmType(@Param("alarmIds") String alarmIds,@Param("alarmType") String alarmType) {
        if (StringUtils.isEmpty(alarmIds)) {
            return new JSONResult(true,StatusCode.FAILURE,"缺少必要参数");
        }
        this.alarmService.updateAlarmType(alarmIds, alarmType);
        return new JSONResult(true, StatusCode.OK, "更新报警信息成功");
    }

    /**
     * 获取多个设备报警信息
     * @param request
     * @return
     */
    @PostMapping(value = "/devices/alarms")
    public JSONResult getAlarmsForAllDevice(HttpServletRequest request) {
        String deviceIds = request.getParameter("deviceIds");
        String alarmType = request.getParameter("alarmType");
        if (StringUtils.isEmpty(alarmType)) {
            alarmType = "0";
        }
        Map<String, List<DeviceAlarmDto>> resultMap = null;
        if (StringUtils.isNotEmpty(deviceIds)) {
            resultMap = alarmService.getAlarmsForDevices(deviceIds, alarmType);
        } else {
            //设备号为空则查询所有
            resultMap = alarmService.getAlarmsForDevices(alarmType);
        }
        return new JSONResult(true, StatusCode.OK,"获取设备报警信息成功", resultMap.entrySet().toArray());
    }

    @RequestMapping(value = "/command/{token}",method = RequestMethod.POST)
    public JSONResult sendCommands(CommandEntity entity,@PathVariable("token") String token,HttpServletRequest request) {
        if (!Authentication.validateToken(token)) {
            return new JSONResult(false, StatusCode.FAILURE,"访问被拒绝");
        }
        //TODO 具体业务逻辑待定
//        String deviceId = entity.getDeviceId();
        String commandType = entity.getCommand();//指令类型
        String parameter = entity.getParameter();//指令参数值
        String extendParam = entity.getExtendParam();//扩展参数
        String message;
        try{
            message = Command.valueOf(commandType).getCommand();
        } catch (Exception e) {
            message = "不识别的指令类型";
            return new JSONResult(true,0,message);
        }


        //TODO 指令发送失败的逻辑
        if (StringUtils.equals(commandType, "C1")) {
            if (StringUtils.equals(parameter, "1")) {
                if (StringUtils.isEmpty(extendParam) ||
                        (!StringUtil.isInDecScope(extendParam, "10%","100%"))) {
                    message = "限速比例未设置或超出可设置范围";
                    return new JSONResult(true,0,message);
                }
            }
        }
        return new JSONResult(true,StatusCode.OK,"指令发送成功");
    }

}
