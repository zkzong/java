package com.zkzong.springredis.case2.repository;

import com.zkzong.springredis.case2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zong on 2017/3/4.
 */
public class UserRepository implements Repository<User> {
    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    public void setRedisTemplate(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void put(User user) {
        redisTemplate.opsForHash().put(user.getObjectKey(), user.getKey(), user);
    }

    @Override
    public User get(User key) {
        return (User) redisTemplate.opsForHash().get(key.getObjectKey(), key.getKey());
    }

    @Override
    public void delete(User key) {
        redisTemplate.opsForHash().delete(key.getObjectKey(), key.getKey());
    }

    @Override
    public List<User> getObjects() {
        List<User> users = new ArrayList<User>();
        for (Object user : redisTemplate.opsForHash().values(User.OBJECT_KEY)) {
            users.add((User) user);
        }
        return users;
    }
}
