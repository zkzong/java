package com.example.rocketmq.springboot.consumer;

import com.example.rocketmq.springboot.domain.OrderPaidEvent;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * OrderPaidEventConsumer
 */
@Service
@RocketMQMessageListener(topic = "order-paid-topic", consumerGroup = "order-paid-consumer")
public class OrderPaidEventConsumer implements RocketMQListener<OrderPaidEvent> {

    @Override
    public void onMessage(OrderPaidEvent orderPaidEvent) {
        System.out.printf("------- OrderPaidEventConsumer received: %s \n", orderPaidEvent);
    }
}
