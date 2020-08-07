package com.zkzong.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zkzong.mp.dto.UserDto;
import com.zkzong.mp.entity.User;
import com.zkzong.mp.mapper.UserMapper;
import com.zkzong.mp.service.UserService;
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
