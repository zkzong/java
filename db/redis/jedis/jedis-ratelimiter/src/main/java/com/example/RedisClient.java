package com.example;

import redis.clients.jedis.Jedis;

/**
 * @Author: zongz
 * @Date: 2024/5/20
 */
public class RedisClient {

    private static Jedis jedis;

    public RedisClient(String host, int port) {
        jedis = new Jedis(host, port);
        jedis.auth("redis");
    }

    // 关闭连接
    public void close() {
        if (jedis != null) {
            jedis.close();
        }
    }

    public Jedis getJedis() {
        return jedis;
    }

}