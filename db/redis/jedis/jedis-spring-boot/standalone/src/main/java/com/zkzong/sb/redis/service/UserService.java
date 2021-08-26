package com.zkzong.sb.redis.service;

import com.zkzong.sb.redis.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 根据接口查询所用的用户
     */
    List<User> findAllUser();

    Map<String, Object> redisMap();
}
