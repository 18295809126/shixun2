package com.jk.utils;

import java.util.Date;

public class ConBean {

    /**
     * 短信平台接口地址
     */
    public static final String SMS_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";

    /**
     *个人平台Id
     *
     *4b81186a628743eca72e9b18a45d2a74
     */
    public static final String SMS_selfID = "5cd7c65e22b248b8a065c929e23c3824";

    /**
     *短信模板ID   生日祝福：191082431
     * 短信验证码 164611295
     * 周伟强的  164594625
     */
    public static final String SMS_mobanId = "164687440";

    /**
     * 当前发送时间获取
     */
    public static final String SMS_Time = TimeUtil.dateTostr(new Date(),"yyyyMMddHHmmss");
    /**
     * 个人平台模板密匙
     * e37095af6acf46a98debd0e3cfc0c64e
     */
    public static final String SMS_PSD = "c606b9a73f4348b4bd7923087cab98d7";

    /**
     * 验证码下一次可发送时间
     */
    public static final String SMS_TIME_OUT = "checkTime";

    public static final String SMS_CHECK_NUMBER_OUT = "checkcode";
}
