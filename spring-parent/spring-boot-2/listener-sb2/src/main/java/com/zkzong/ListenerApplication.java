package com.zkzong;

import com.zkzong.listener.MyEvent;
import com.zkzong.listener.MyListener1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: zong
 * @Date: 2022/1/6
 */
@SpringBootApplication
public class ListenerApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ListenerApplication.class, args);
        // 装载监听
        context.addApplicationListener(new MyListener1());
        // 发布事件
        context.publishEvent(new MyEvent("测试事件"));
    }
}
