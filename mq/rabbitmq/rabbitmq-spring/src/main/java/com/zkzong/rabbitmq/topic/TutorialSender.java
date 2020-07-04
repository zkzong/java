package com.zkzong.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/21.
 */
public class TutorialSender {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("topic/rabbit-sender-context.xml");//loading beans
        AmqpTemplate amqpTemplate = (AmqpTemplate) context.getBean("tutorialTemplate");// getting a reference to the sender bean

        for (int i = 0; i < 10; i++) {
            amqpTemplate.convertAndSend("my.routingkey.1", "Message # " + i + " on " + new Date());// send
        }
    }
}
