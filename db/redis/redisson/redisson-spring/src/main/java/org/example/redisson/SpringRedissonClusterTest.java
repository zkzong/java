package org.example.redisson;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRedissonClusterTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-redisson-cluster.xml");
        RedissonClient redisson = (RedissonClient) applicationContext.getBean("cluster");
        // 首先获取redis中的key-value对象，key不存在没关系
        RBucket<String> keyObject = redisson.getBucket("key");
        // 如果key存在，就设置key的值为新值value
        // 如果key不存在，就设置key的值为value
        keyObject.set("value");
    }
}
