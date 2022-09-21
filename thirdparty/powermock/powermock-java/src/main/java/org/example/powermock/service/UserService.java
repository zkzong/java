package org.example.powermock.service;

import org.example.powermock.common.User;
import org.example.powermock.dao.UserDao;

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
