package com.zdzc.electrocar.common;

/**
 * 通用token校验
 */
public class Authentication {

    public static boolean validateToken(String token) {
        if (token.equals("ffa1dc92f01b729285136d8edd7f68ea")) {
            return true;
        }
        return false;
    }
}
