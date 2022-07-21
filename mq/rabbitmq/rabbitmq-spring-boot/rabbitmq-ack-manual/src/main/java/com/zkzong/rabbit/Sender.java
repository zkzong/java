package com.zkzong.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        rabbitTemplate.setConfirmCallback((correlationData, b, s) -> {
            System.out.println("correlationData: " + correlationData);
            System.out.println("b: " + b);
            System.out.println("s: " + s);
        });
        rabbitTemplate.setReturnCallback((message, i, s, s1, s2) -> {
            System.out.println("message: " + message);
            System.out.println("i: " + i);
            System.out.println("s: " + s);
            System.out.println("s1: " + s1);
            System.out.println("s2: " + s2);
        });

        // 在RabbitCongig中绑定了exchange-test和routingkey-test，所以这里不需要指定exchange和routingkey
        rabbitTemplate.convertAndSend("hello rabbitmq");
    }
}
