package org.example.lettuce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    //@Bean
    //LettuceConnectionFactory lettuceConnectionFactory() {
    //    return new LettuceConnectionFactory();
    //}

    @Bean
    public <T> RedisTemplate<String, T> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisTemplate<String, T> template = new RedisTemplate<>();
        template.setConnectionFactory(lettuceConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        GenericToStringSerializer genericToStringSerializer = new GenericToStringSerializer(Object.class);
        template.setValueSerializer(genericToStringSerializer);
        return template;
    }
}
