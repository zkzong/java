package com.zkzong.jedis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by Zong on 2016/9/25.
 */
public class RedisTest {
    public static void main(String[] args) {
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("Connection to server sucessfully");
        // 查看服务是否运行
        System.out.println("Server is running: " + jedis.ping());

        jedis.set("key", "Redis tutorial");
        System.out.println("Stored string in redis: " + jedis.get("key"));

        jedis.lpush("tlist", "Redis");
        jedis.lpush("tlist", "MongoDB");
        jedis.lpush("tlist", "Mysql");
        List<String> list = jedis.lrange("tlist", 0, 5);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Stored string in redis: " + list.get(i));
        }
    }
}
