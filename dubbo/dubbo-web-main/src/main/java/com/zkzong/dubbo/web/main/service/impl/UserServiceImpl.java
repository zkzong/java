package com.zkzong.dubbo.web.main.service.impl;

import com.zkzong.dubbo.web.main.entity.User;
import com.zkzong.dubbo.web.main.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by Zong on 2017/3/30.
 */
@Service
public class UserServiceImpl implements UserService {
    public User queryUser() {
        User user = new User();
        user.setName("zong");
        user.setAge(20);
        user.setAddress("henan");
        return user;
    }
}
