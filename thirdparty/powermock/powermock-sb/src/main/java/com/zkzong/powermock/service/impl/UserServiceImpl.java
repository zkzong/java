package com.zkzong.powermock.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkzong.powermock.entity.User;
import com.zkzong.powermock.mapper.UserMapper;
import com.zkzong.powermock.req.UserReq;
import com.zkzong.powermock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> query(String userName) {
        Map<String, Object> map = new HashMap<>();
        map.put("f_user_name", userName);
        return userMapper.selectByMap(map);
    }

    @Override
    public List<User> query(UserReq req) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUserName, req.getUserName());
        List<User> users = userMapper.selectList(queryWrapper);
        return users;
    }
}
