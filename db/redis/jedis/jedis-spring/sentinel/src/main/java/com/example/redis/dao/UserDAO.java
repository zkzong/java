package com.example.redis.dao;

import com.example.redis.pojo.User;

/**
 * Created by Zong on 2017/2/17.
 */
public interface UserDAO {
    void saveUser(final User user);

    User getUser(final long id);
}
