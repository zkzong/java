package com.zkzong.tx.service.impl;

import com.zkzong.tx.service.TxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Zong
 * @Date: 2018/11/14
 */
@Service
public class TxServiceImpl implements TxService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Transactional
    @Override
    public void insert() {
        // 失败后，回滚
        redisTemplate.opsForValue().set("redis", "redis");
        int i = 1 / 0;
    }
}
