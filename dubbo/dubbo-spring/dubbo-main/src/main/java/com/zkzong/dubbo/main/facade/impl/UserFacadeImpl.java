package com.zkzong.dubbo.main.facade.impl;

import com.zkzong.dubbo.main.entity.User;
import com.zkzong.dubbo.main.facade.UserFacade;
import com.zkzong.dubbo.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zong on 2017/3/30.
 */
@Service("userFacade")
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    public User queryUser() {
        return userService.queryUser();
    }
}
