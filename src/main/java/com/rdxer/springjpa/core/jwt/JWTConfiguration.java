package com.rdxer.springjpa.core.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


public class JWTConfiguration {
    public static String secret = "nRvyYC4soFxBdZ-F-5Nnzz5USXstR1YylsTd-mA0aKtI9HUlriGrtkf-TiuDapkLiUCogO3JOK7kwZisrHp6wA";
//    public static int sessionTime = 86400000; // 1 天
//    public static int sessionTime = 60 * 60 * 24 * 1000;
    /// 超时时长 1 天
    public static long sessionTime =  1000 * 60 * 60 * 24;
    /// 超时时长 30 天
    public static long sessionTime_remember_me =  1000L * 60 * 60 * 24 * 30;

}
