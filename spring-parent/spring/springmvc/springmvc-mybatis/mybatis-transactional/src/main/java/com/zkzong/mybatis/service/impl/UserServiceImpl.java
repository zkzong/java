package com.zkzong.mybatis.service.impl;

import com.zkzong.mybatis.domain.User;
import com.zkzong.mybatis.mapper.UserMapper;
import com.zkzong.mybatis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zong on 17-5-31.
 */
@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(String name, int age) {
        return userMapper.insertUser(name, age);
    }
}
