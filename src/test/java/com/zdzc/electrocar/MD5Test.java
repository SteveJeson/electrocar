package com.zdzc.electrocar;

import com.zdzc.electrocar.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MD5Test {

    @Test
    public void testMD5() {
        String method = "GET";
        String uri = "/bsp/api/GPSInfo/916122700110";
        String pwd = "123456";
        String authStr = method+uri+pwd;
        String md5str = MD5Util.MD5(authStr);
        System.out.println("加密后："+md5str);//ffa1dc92f01b729285136d8edd7f68ea
        System.out.println("再加密:"+MD5Util.transferMD5(md5str));//ffa1dc92f01b729285136d8edd7f68ea
        System.out.println("解密后："+MD5Util.getStrfromMD5(md5str));
    }
}
