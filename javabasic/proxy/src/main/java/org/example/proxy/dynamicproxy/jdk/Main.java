package org.example.proxy.dynamicproxy.jdk;

import org.example.proxy.SmsService;
import org.example.proxy.SmsServiceImpl;

public class Main {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
}
