package org.example.sb2.rabbitmq.ack;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Comsumer {

    private Logger log = LoggerFactory.getLogger(Comsumer.class);

    @RabbitListener(queues = "queue-test")
    public void process(Message message, Channel channel) throws IOException {
        // 采用手动应答模式, 手动确认应答更为安全稳定
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        log.info("receive: " + new String(message.getBody()));
    }
}
