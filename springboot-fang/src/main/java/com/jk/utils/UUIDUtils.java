package com.jk.utils;

import java.util.UUID;

/**
 * UUID工具类
 * @return
 */
public class UUIDUtils {
    /**
     * UUID封装方法
     * @return
     */
    public static String UUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return uuid;
    }
}
