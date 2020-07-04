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
public class Producer2 {

    @Value("${amqp.routing.key2}")
    private String key2;

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send2Queue2() {
        amqpTemplate.convertAndSend(key2, "Queue2");
    }
}
