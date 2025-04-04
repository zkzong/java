package com.example.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mp.dto.UserDto;
import com.example.mp.entity.User;
import com.example.mp.mapper.UserMapper;
import com.example.mp.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> query(UserDto dto) {
        PageHelper.startPage(1, 1);
        List<User> users = userMapper.selectList(null);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }
}
