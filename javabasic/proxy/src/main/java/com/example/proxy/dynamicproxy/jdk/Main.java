package com.example.proxy.dynamicproxy.jdk;

import com.example.proxy.SmsService;
import com.example.proxy.SmsServiceImpl;

public class Main {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
}
