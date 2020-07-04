package com.zkzong.sb.shiro.sevice.impl;

import com.zkzong.sb.shiro.dao.UserInfoDao;
import com.zkzong.sb.shiro.entity.UserInfo;
import com.zkzong.sb.shiro.sevice.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}