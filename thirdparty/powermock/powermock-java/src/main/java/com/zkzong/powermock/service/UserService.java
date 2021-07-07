package com.zkzong.powermock.service;

import com.zkzong.powermock.common.User;
import com.zkzong.powermock.dao.UserDao;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int queryUserCount() {
        return userDao.getCount();
    }

    public void saveUser(User user) {
        userDao.insertUser(user);
    }
}
