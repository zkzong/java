package com.zkzong.rabbitmq.topic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/4/21.
 */
public class TutorialListenerContainer {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("topic/rabbit-listener-context.xml");
    }
}
