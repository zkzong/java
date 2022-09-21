package org.example.sb2.rabbitmq.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by Zong on 2017/5/12.
 */
//@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender:" + context);
        amqpTemplate.convertAndSend("hello", context);
    }
}
