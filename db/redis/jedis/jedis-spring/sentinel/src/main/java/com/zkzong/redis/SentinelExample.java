package com.zkzong.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.Collection;

public class SentinelExample {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/sentinel/spring-redisSentinel.xml");
        JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) ac.getBean("jedisConnectionFactory");
        if (jedisConnectionFactory.getSentinelConnection().isOpen()) {
            Collection<RedisServer> c = jedisConnectionFactory.getSentinelConnection().masters();
            System.out.println(c);
        }
    }
}
