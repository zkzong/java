package com.example.sb2.rabbitmq.ack.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * rabbitMq 配置类，使用默认RabbitTemplate
 */
//@Configuration
public class DefaultRabbitConfig {

    Logger log = LoggerFactory.getLogger(DefaultRabbitConfig.class);

    /**
     * 定义一个hello的队列
     * Queue 可以有4个参数
     * 1.队列名
     * 2.durable 持久化消息队列 ,rabbitmq重启的时候不需要创建新的队列 默认true
     * 3.auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
     * 4.exclusive 表示该消息队列是否只在当前connection生效,默认是false
     */
    @Bean
    public Queue helloQueue() {
        return new Queue("queue-test");
    }

}
