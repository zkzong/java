package com.zkzong.rabbit;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class Receiver {

    @RabbitListener(queues = "hello")
    public void receive(Channel channel, Message message) throws IOException {
        System.out.println("Received <" + message + ">");
        //if (true) {
        //    throw new RuntimeException("Something went wrong");
        //}
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
