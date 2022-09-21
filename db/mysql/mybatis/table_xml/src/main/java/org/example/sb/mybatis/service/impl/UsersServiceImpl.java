package org.example.sb.mybatis.service.impl;

import org.example.sb.mybatis.domain.Users;
import org.example.sb.mybatis.mapper.UsersMapper;
import org.example.sb.mybatis.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public int insertBatch(List<Users> userList) {
        return usersMapper.insertBatch(userList);
    }

    @Override
    public int insertAndGetId(Users users) {
        return usersMapper.insertAndGetId(users);
    }

    @Override
    public Users findByIndex(String userName, int age) {
        return usersMapper.findByIndex(userName, age);
    }

    @Override
    public Users findByMap(Map map) {
        return usersMapper.findByMap(map);
    }

    @Override
    public Users findByParam(String userName, int age) {
        return usersMapper.findByParam(userName, age);
    }

    @Override
    public List<Users> namein(List<String> names, String name) {
        return usersMapper.namein(names, name);
    }

}
