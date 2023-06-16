package org.example.tx.service.impl;

import org.example.tx.mapper.UserMapper;
import org.example.tx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zong on 2017/6/1.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertUser(String name, int age) {
        userMapper.insertUser(name, age);
    }

}
