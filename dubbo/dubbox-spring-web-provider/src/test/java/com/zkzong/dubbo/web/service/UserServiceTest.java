package com.zkzong.dubbo.web.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Author: Zong
 * @Date: 2018/11/10
 */
public class UserServiceTest {

    @Test
    public void startUserProvider() throws IOException {
        System.out.println("准备启动UserServiceProvider");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:provider.xml");
        UserService userService = (UserService) context.getBean("userService");
        System.out.println("启动UserServiceProvider完成");
        System.in.read();
    }
}