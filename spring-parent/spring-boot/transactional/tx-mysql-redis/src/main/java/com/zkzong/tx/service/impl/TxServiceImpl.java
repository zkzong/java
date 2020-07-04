package com.zkzong.tx.service.impl;

import com.zkzong.tx.mapper.PersonMapper;
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
    private PersonMapper personMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Transactional
    @Override
    public void insertAll(String name, int age) {
        // 失败后，redis有值，mysql没值
        redisTemplate.opsForValue().set("tx", "tx");
        int i = 1 / 0;
        personMapper.insertPerson(name, age);
    }

    @Transactional
    @Override
    public void insertMysqlThenRedis(String name, int age) {
        // 事务回滚，mysql没值，redis没值
        personMapper.insertPerson(name, age);
        int i = 1 / 0;
        redisTemplate.opsForValue().set("mysql then redis", "mysql then redis");

    }
}
