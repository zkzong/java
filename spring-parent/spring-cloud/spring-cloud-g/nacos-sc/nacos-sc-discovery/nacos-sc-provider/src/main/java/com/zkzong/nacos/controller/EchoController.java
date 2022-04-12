package com.zkzong.nacos.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class EchoController {

    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return "Hello Nacos Discovery " + string;
    }

    // OpenFeign 默认的接口超时时间为 1s，可以修改调用方ribbon的配置
    @PostMapping("echo1")
    public String echo1(@RequestParam String name) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return "echo, " + name;
    }

}
