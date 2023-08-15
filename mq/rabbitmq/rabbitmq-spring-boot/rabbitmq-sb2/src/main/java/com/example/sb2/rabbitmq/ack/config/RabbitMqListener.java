package com.example.sb2.rabbitmq.ack.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqListener {

    @RabbitListener(queues = "queue-test-callback")
    public void listen(byte[] message) {
        String msg = new String(message);
        System.out.println("Received a new notification...");
        System.out.println(msg);
    }
}
