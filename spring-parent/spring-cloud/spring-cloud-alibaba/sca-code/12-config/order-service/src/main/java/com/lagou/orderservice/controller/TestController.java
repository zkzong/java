package com.lagou.orderservice.controller;

import com.lagou.orderservice.config.CustomConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope
public class TestController {
    @Resource
    private CustomConfig customConfig;

    @Value("${custom.aaa}")
    private String aaa;

    @GetMapping("/test")
    public String test() {
        return "flag:" + customConfig.getFlag() + "<br/> database:" + customConfig.getDatabase() + " " + aaa;
    }
}
