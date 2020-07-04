package com.zkzong.mybatis.service.impl;

import com.zkzong.mybatis.mapper.PersonMapper;
import com.zkzong.mybatis.mapper.UserMapper;
import com.zkzong.mybatis.service.TxService;
import com.zkzong.mybatis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zong on 17-5-31.
 */
@Service
public class TxServiceImpl implements TxService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PersonMapper personMapper;

    @Transactional
    @Override
    public void insertTx(String name, int age) {
        userMapper.insertUser(name, age);
        int i = 1 / 0;
        personMapper.insertPerson(name, age);
    }
}
