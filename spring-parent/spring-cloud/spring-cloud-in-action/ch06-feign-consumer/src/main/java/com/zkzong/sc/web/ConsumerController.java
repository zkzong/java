package com.zkzong.sc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zong on 2017/7/10.
 */
@RestController
public class ConsumerController {
    @Autowired
    HelloService helloService;
    @Autowired
    RefactorHelloService refactorHelloService;

    @RequestMapping(value = "feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }

    @RequestMapping(value = "feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("zong")).append("\n");
        sb.append(helloService.hello("zong", 30)).append("\n");
        sb.append(helloService.hello(new User("zong", 30))).append("\n");
        return sb.toString();
    }

    @RequestMapping(value = "feign-consumer3", method = RequestMethod.GET)
    public String helloConsumer3() {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("zong")).append("\n");
        sb.append(refactorHelloService.hello("zong", 30)).append("\n");
        sb.append(refactorHelloService.hello(new com.zkzong.sc.dto.User("zong", 30))).append("\n");
        return sb.toString();
    }
}
