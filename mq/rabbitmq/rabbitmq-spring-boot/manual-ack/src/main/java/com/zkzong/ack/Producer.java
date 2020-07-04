package com.zkzong.ack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class Producer {

    private Logger log = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 给hello队列发送消息
     */
    public void send() {
        String msg = "hello";
        log.info("Producer, " + msg);
        CorrelationData correlationData = new CorrelationData("data");
        rabbitTemplate.convertAndSend("exchange-test", "routingkey-test", msg, correlationData);
    }

}
