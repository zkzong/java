package com.atguigu.controller;

import com.atguigu.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zkzong
 * @Date: 2019/10/19
 */
@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        String hello = helloService.sayHello("tomcat..");
        return hello;
    }

    //  /WEB-INF/views/success.jsp
    @RequestMapping("/suc")
    public String success() {
        return "success";
    }

}
