package com.example.redisson.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class RedissonConfig {
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() throws IOException {
        //1.配置连接
        Config config = new Config();
        config.useSingleServer()
                //可以用"rediss://"来启用SSL连接
                .setAddress("redis://127.0.0.1:6379")
                .setPassword("redis");
        //2.创建客户端
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }
}
