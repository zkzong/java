package com.zkzong.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${name:zong}")
    private String name;

    /**
     * http://localhost:8080/config/name
     */
    @RequestMapping("/name")
    public String name() {
        return name;
    }
}
