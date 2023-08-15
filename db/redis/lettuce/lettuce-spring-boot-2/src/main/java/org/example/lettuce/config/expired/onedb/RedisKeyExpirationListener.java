package com.example.lettuce.config.expired.onedb;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * 监听指定db的过期事件__keyevent@*__:expired
 */
@Component
public class RedisKeyExpirationListener implements MessageListener {

    /**
     * 针对 redis 数据失效事件，进行数据处理
     *
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 获取到失效的 key，进行业务处理
        String expiredKey = message.toString();
        System.out.println(expiredKey);
    }
}
