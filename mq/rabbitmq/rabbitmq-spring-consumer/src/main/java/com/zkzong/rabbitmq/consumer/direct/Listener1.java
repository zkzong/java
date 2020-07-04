package com.zkzong.rabbitmq.consumer.direct;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;

/**
 * @Author: zong
 * @Date: 2019.1.4
 */
public class Listener1 implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(new String(message.getBody(),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
