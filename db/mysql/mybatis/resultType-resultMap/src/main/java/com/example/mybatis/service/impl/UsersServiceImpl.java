package com.example.mybatis.service.impl;

import com.example.mybatis.domain.Users;
import com.example.mybatis.mapper.UsersMapper;
import com.example.mybatis.service.UsersService;
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
    public List<String> getUserName() {
        return usersMapper.getUserName();
    }

    @Override
    public List<Users> getUsersMap() {
        return usersMapper.getUsersMap();
    }

    @Override
    public List<Users> getUsersType() {
        return usersMapper.getUsersType();
    }

}
