package com.zkzong.proxy.dynamicproxy.jdk;

import com.zkzong.proxy.SmsService;
import com.zkzong.proxy.SmsServiceImpl;

public class Main {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
}
