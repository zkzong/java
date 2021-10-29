package com.zkzong.apollo.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: zong
 * @Date: 2021/10/26
 */
@ConfigurationProperties(prefix = "config")
@Component
public class PropConfig {

    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
