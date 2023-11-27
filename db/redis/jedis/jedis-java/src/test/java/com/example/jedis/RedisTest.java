package com.example.jedis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

/**
 * Created by Zong on 2016/9/25.
 */
public class RedisTest {
    private Jedis jedis;

    @Before
    public void before() {
        // 单机
        // 连接本地的 Redis 服务
        //jedis = new Jedis("127.0.0.1");
        //System.out.println("Connection to server sucessfully");
        //// 查看服务是否运行
        //System.out.println("Server is running: " + jedis.ping());

        // 连接池
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(25);
        config.setMaxIdle(20);
        config.setMinIdle(5);
        // 无密码
        //JedisPool pool = new JedisPool(config, "127.0.0.1", 6379);
        // 有密码
        JedisPool pool = new JedisPool(config, "127.0.0.1", 6379, 60000, "redis");
        jedis = pool.getResource();
        jedis.select(0);
    }

    @Test
    public void string() {
        // string
        jedis.set("key", "Redis tutorial");
        System.out.println("Stored string in redis: " + jedis.get("key"));
    }

    @Test
    public void list() {
        // list
        jedis.lpush("tlist", "Redis");
        jedis.lpush("tlist", "MongoDB");
        jedis.lpush("tlist", "Mysql");
        jedis.expire("tlist", 1000);
        List<String> list = jedis.lrange("tlist", 0, 5);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Stored string in redis: " + list.get(i));
        }
    }

    @Test
    public void hash() {
        // hash
        jedis.hset("testHash", "field1", "value1");
        jedis.hset("testHash", "field2", "value1");
        System.out.println(jedis.hgetAll("testHash"));
    }

    @Test
    public void set() {
        // set
        jedis.sadd("key", "v1", "v2");
        System.out.println(jedis.scard("key"));
    }

    @Test
    public void zset() {
        // zset
        //jedis.zs
    }
}
