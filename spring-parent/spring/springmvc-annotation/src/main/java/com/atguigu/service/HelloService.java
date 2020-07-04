package com.atguigu.service;

import org.springframework.stereotype.Service;

/**
 * @Author: zkzong
 * @Date: 2019/10/19
 */
@Service
public class HelloService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
