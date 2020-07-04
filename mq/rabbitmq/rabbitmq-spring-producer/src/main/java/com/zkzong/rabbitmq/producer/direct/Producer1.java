package com.zkzong.rabbitmq.producer.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: zong
 * @Date: 2019.1.4
 */
@Component
public class Producer1 {

    @Value("${amqp.routing.key1}")
    private String key1;

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send2Queue1() {
        amqpTemplate.convertAndSend(key1, "Queue1");
    }
}
