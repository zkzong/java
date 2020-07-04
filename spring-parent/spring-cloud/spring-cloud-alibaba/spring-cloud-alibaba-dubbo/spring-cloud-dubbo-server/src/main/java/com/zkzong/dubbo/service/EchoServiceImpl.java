package com.zkzong.dubbo.service;

import org.apache.dubbo.config.annotation.Service;

@Service
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String message) {
        return "[echo] Hello, " + message;
    }
}
