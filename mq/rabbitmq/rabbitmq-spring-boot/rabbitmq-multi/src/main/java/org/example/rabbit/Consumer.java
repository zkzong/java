package com.example.rabbit;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Consumer {

    @RabbitListener(queues = "hello", containerFactory = "factory")
    public void receive(Channel channel, Message message) throws IOException {
        System.out.println("Received hello <" + message + ">");

        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
