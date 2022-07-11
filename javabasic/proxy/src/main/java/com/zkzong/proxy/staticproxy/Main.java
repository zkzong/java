package com.zkzong.proxy.staticproxy;

import com.zkzong.proxy.SmsService;
import com.zkzong.proxy.SmsServiceImpl;

public class Main {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("java");
    }
}

