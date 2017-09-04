package com.zdzc.electrocar.common;

import com.alibaba.fastjson.JSONObject;
import com.zdzc.electrocar.util.ByteUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by liuw on 2017/8/31.
 * 通用业务处理
 */
public class CommonBusiness {
    private static Logger log = LoggerFactory.getLogger(CommonBusiness.class);
    /**
     * 通过报警信息获取ACC状态 1：开启 0：关闭
     * @param alarmStatus
     * @return
     */
    public static int getAccStatus(int alarmStatus) {
        String binStr = ByteUtil.get32BitBinStrFromInt(alarmStatus);
        int accStatus = Integer.valueOf(binStr.substring(0,1));
        return accStatus;
    }

    /**
     * 通过报警信息获取ACC状态 1：开启 0：关闭
     * 此方法为备用方法
     * 当参数alarmStatus为二进制字符串时可调用
     */
    public static int getAccStatus(String alarmStatus) {
        int accStatus = Integer.valueOf(alarmStatus.substring(0,1));
        return accStatus;
    }

    /**
     * 获取高德地图GPS坐标
     * @param lng
     * @param lat
     * @return
     */
    public static double[] getGaodeGPS(double lng,double lat) {
        double[] gps = new double[2];
        String locations = String.valueOf(lng)+","+String.valueOf(lat);
        String key = "261b9ce89ab991fc23a481974ad6b881";//高德地图API KEY
        //高德地图API URL
        String httpUrl = "http://restapi.amap.com/v3/assistant/coordinate/convert?locations="+locations
                +"&coordsys=gps&output=json&key="+key;
        BufferedReader br = null;
        String result = "";
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                result += line;
            }
            br.close();
        } catch (MalformedURLException e) {
            log.error("=========MalformedURLException 高德地图API URL解析错误！==========");
        } catch (IOException e) {
            log.error("=========IOException 高德地图API URL IO异常！");
        }
        //将返回的字符串数据转为JSON对象
        JSONObject jsonObject = JSONObject.parseObject(result);
        String loc = jsonObject.getString("locations");
        String[] strArr = StringUtils.split(loc,",");
        gps[0] = Double.valueOf(strArr[0]);
        gps[1] = Double.valueOf(strArr[1]);
        return gps;
    }
    


}
