package com.zkzong.rabbitmq.direct;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2017/4/21.
 */
public class MessageReceiver implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(new String(message.getBody(),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("direct/consumer.xml");
    }
}
