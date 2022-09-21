package org.example.sb2.rabbitmq.ack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CallBackProducer implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    private Logger log = LoggerFactory.getLogger(CallBackProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        // 指定 ConfirmCallback
        rabbitTemplate.setConfirmCallback(this);
        // 指定 ReturnCallback
        rabbitTemplate.setReturnCallback(this);
    }

    public CallBackProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
    }

    /**
     * 给hello队列发送消息
     */
    public void send() {
        String msg = "hello callback";
        log.info("Producer, " + msg);
        rabbitTemplate.convertAndSend("queue-test-callback", msg);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.info("消息发送成功" + correlationData);
        } else {
            log.info("消息发送失败:" + cause);
        }
    }

    // todo 没有调用
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        // 反序列化对象输出
        log.info("消息主体: " + SerializationUtils.deserialize(message.getBody()));
        log.info("应答码: " + replyCode);
        log.info("描述：" + replyText);
        log.info("消息使用的交换器 exchange : " + exchange);
        log.info("消息使用的路由键 routing : " + routingKey);
    }
}
