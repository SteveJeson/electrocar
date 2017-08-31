package com.zdzc.electrocar.common;

import com.zdzc.electrocar.util.ByteUtil;

/**
 * Created by liuw on 2017/8/31.
 */
public class CommonBusiness {
    /**
     * 通过报警信息获取ACC状态 1：开启 0：关闭
     * @param alarmStatus
     * @return
     */
    public static byte getAccStatus(int alarmStatus) {
        String binStr = ByteUtil.get32BitBinStrFromInt(alarmStatus);
        int accStatus = Integer.valueOf(binStr.substring(0,1));
        return (byte)accStatus;
    }
}
