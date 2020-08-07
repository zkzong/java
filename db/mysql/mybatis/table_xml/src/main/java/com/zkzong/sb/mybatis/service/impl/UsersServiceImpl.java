package com.zkzong.sb.mybatis.service.impl;


import com.zkzong.sb.mybatis.domain.Users;
import com.zkzong.sb.mybatis.mapper.UsersMapper;
import com.zkzong.sb.mybatis.service.UsersService;
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
    public Users findByUserName(String userName) {
        return usersMapper.findByUserName(userName);
    }

    @Override
    public void insertOne(String userName, int age) {
        usersMapper.insertOne(userName, age);
    }

}
