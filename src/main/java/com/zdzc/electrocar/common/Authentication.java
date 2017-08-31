package com.zdzc.electrocar.common;

import tk.mybatis.mapper.util.StringUtil;

/**
 * 通用token校验
 */
public class Authentication {

    public static boolean validateToken(String token) {
        if (StringUtil.isNotEmpty(token) && token.equals("ffa1dc92f01b729285136d8edd7f68ea")) {
            return true;
        }
        return false;
    }
}
