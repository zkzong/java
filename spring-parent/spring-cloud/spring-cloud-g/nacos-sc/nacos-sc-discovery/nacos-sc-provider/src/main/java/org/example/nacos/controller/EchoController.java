package org.example.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class EchoController {

    @RequestMapping(value = "/http/get/{string}", method = RequestMethod.GET)
    public String get(@PathVariable String string) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return "Hello Nacos Discovery " + string;
    }

    // OpenFeign 默认的接口超时时间为 1s，可以修改调用方ribbon的配置

    @GetMapping("/feign/get")
    public String get() throws InterruptedException {
        System.out.println("feign get start");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("feign get end");
        return "GET";
    }

    @PostMapping("/feign/post")
    public String post(@RequestParam String name) throws InterruptedException {
        System.out.println("feign post start");
        TimeUnit.SECONDS.sleep(4);
        System.out.println("feign post end");
        return "POST " + name;
    }

}
