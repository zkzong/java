package com.zkzong.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkzong.mp.dao.UserMapper;
import com.zkzong.mp.entity.User;
import com.zkzong.mp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
