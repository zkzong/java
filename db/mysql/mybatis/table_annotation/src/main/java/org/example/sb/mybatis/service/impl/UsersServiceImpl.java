package org.example.sb.mybatis.service.impl;


import org.example.sb.mybatis.domain.Users;
import org.example.sb.mybatis.mapper.UsersMapper;
import org.example.sb.mybatis.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zong on 2017/6/1.
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> getAllUsers() {
        return usersMapper.getAllUsers();
    }

    @Override
    public Users findByName(String name) {
        return usersMapper.findByName(name);
    }

    @Override
    public void insertOne(String name, int age) {
        usersMapper.insertOne(name, age);
    }

}
