package com.zkzong.consul.controller;

import com.zkzong.consul.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    /**
     * 调用 hello 服务
     */
    @Autowired
    private HelloService helloService;

    @GetMapping("/actuator/health")
    public String health() {
        return "SUCCESS";
    }

    /**
     * 接收前端传来的参数，调用远程接口，并返回调用结果
     */
    @GetMapping("/hello")
    public String hello(String name) {
        return helloService.sayHello(name);
    }

}
