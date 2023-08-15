package com.example.lettuce.config.expired.onedb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @Author: zong
 * @Date: 2021/12/28
 */
@Configuration
public class RedisListenerConfig {

    @Autowired
    private RedisKeyExpirationListener redisKeyExpirationListener;

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        // 监听指定db的过期事件__keyevent@*__:expired
        container.addMessageListener(redisKeyExpirationListener, new PatternTopic("__keyevent@" + 2 + "__:expired"));
        return container;
    }
}
