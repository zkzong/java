package com.example.proxy.staticproxy;

import com.example.proxy.SmsService;
import com.example.proxy.SmsServiceImpl;

public class Main {
    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("java");
    }
}

