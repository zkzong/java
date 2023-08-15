package com.example.consul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    /**
     * 注意：新版Spring Cloud Consul 默认注册健康检查接口为：/actuator/health
     *
     * @return SUCCESS
     */
    @GetMapping("/actuator/health")
    public String health() {
        return "SUCCESS";
    }

    /**
     * 提供 sayHello 服务:根据对方传来的名字 XX，返回:hello XX
     *
     * @return String
     */
    @PostMapping("/sayHello")
    public String sayHello(@RequestParam("name") String name) {
        return "hello," + name;
    }

}
