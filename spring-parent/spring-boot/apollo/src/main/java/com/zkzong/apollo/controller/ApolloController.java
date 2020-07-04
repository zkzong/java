package com.zkzong.apollo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Zong
 * @Date: 2019/3/2
 */
@RestController
public class ApolloController {

    @Value("${config_info}")
    private String configInfo;

    @RequestMapping("/getConfigInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
