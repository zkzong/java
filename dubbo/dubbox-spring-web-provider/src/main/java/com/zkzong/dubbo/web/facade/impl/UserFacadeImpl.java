package com.zkzong.dubbo.web.facade.impl;

import com.zkzong.dubbo.web.entity.User;
import com.zkzong.dubbo.web.facade.UserFacade;
import com.zkzong.dubbo.web.service.UserService;
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
        //return userService.queryUser();
        return null;
    }
}
