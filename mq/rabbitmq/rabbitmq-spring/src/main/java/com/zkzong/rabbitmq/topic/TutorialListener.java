package com.zkzong.rabbitmq.topic;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Created by Administrator on 2017/4/21.
 * This class implements org.springframework.amqp.core.MessageListener.
 * It is tied to TUTORIAL_EXCHANGE and listing to an anonomous queue
 * which picks up message in the  TUTORIAL_EXCHANGE with a routing pattern of
 * my.routingkey.1  specified in rabbt-listener-contet.xml file.
 */
public class TutorialListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        String messageBody = new String(message.getBody());
        System.out.println("Listener received message----->" + messageBody);
    }
}
