package com.zkzong.controller;

import com.zkzong.listener.MyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/listener")
public class ListenerController {

    @Resource
    private ApplicationContext applicationContext;

    @RequestMapping("/get")
    public String get() {
        applicationContext.publishEvent(new MyEvent("手动触发"));
        return "success";
    }
}
