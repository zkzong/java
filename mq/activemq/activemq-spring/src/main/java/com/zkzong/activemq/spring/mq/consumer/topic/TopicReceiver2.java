package org.example.activemq.spring.mq.consumer.topic;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Zong on 2017/3/1.
 * Topic消息监听器
 */
@Component
public class TopicReceiver2 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("TopicReceiver2接收到消息:" + ((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
