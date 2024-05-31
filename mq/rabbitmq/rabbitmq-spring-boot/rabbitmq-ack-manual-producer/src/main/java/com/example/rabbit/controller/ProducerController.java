package com.example.rabbit.controller;

import com.example.rabbit.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/send")
    public String send() {

        // 在RabbitCongig中绑定了exchange-test和routingkey-test，所以这里需要指定exchange和routingkey
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.ROUTING_KEY, "hello rabbitmq");

        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME + 1, RabbitConfig.ROUTING_KEY, "hello rabbitmq");

        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.ROUTING_KEY + 1, "hello rabbitmq");

        return "send";
    }
}
