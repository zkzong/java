//package com.example.rabbit;
//
//import com.example.rabbit.config.RabbitConfig;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.connection.CorrelationData;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
//import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Producer2 implements ConfirmCallback, ReturnCallback {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    public void send() {
//        //消息发送失败返回到队列中, yml需要配置 publisher-returns: true
//        rabbitTemplate.setMandatory(true);
//        //消息消费者确认收到消息后，手动ack回执
//        rabbitTemplate.setConfirmCallback(this);
//        rabbitTemplate.setReturnCallback(this);
//
//        // 在RabbitCongig中绑定了exchange-test和routingkey-test，所以这里需要指定exchange和routingkey
//        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.ROUTING_KEY, "hello rabbitmq");
//    }
//
//    @Override
//    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//        System.out.println("---- confirm ----ack=" + ack + "  cause=" + String.valueOf(cause));
//        System.out.println("correlationData -->" + correlationData.toString());
//        if (ack) {
//            System.out.println("---- confirm ----ack==true  cause=" + cause);
//        } else {
//            System.out.println("---- confirm ----ack==false  cause=" + cause);
//        }
//    }
//
//    @Override
//    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
//        System.out.println("---- returnedMessage ----replyCode=" + replyCode + " replyText=" + replyText + " ");
//    }
//}
