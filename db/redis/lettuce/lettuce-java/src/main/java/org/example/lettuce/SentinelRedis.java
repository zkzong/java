package com.example.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;

/**
 * @Author: zong
 * @Date: 2020/1/7
 */
public class SentinelRedis {
    public static void main(String[] args) {
        RedisURI redisUri = RedisURI.Builder
                .sentinel("sentinelhost1", "clustername")
                .withSentinel("sentinelhost2").build();
        RedisClient client = RedisClient.create(redisUri);

        StatefulRedisConnection<String, String> connect = client.connect();
    }
}
