package com.zkzong.rabbitmq.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/4/21.
 */
public class MessageSender {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("direct/producer.xml");
        AmqpTemplate amqpTemplate = (AmqpTemplate) context.getBean("myAmqpTemplate");

        amqpTemplate.convertAndSend("hello", "hello world");
    }
}
