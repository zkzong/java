package com.zkzong.sb.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zkzong.sb.dubbo.api.DubboService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dubbo")
public class DubboController {

    @Reference(version = "1.0.0")
    DubboService dubboService;

    @RequestMapping("sayHello")
    public void sayHello() {
        System.out.println("dubbo开始调用");
        dubboService.sayHello("consumer 请求服务");
    }

}
