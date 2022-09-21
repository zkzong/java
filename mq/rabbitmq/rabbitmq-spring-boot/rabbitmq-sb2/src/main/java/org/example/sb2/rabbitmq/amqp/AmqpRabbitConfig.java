package org.example.sb2.rabbitmq.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * Created by Zong on 2017/5/12.
 */
//@Configuration
public class AmqpRabbitConfig {
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
