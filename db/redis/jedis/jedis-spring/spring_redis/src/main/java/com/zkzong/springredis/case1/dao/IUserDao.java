package com.zkzong.springredis.case1.dao;

import com.zkzong.springredis.case1.entity.User;

import java.util.List;

/**
 * Created by zong on 2017/3/2.
 */
public interface IUserDao {
    boolean add(User user);

    boolean add(List<User> list);

    void delete(String key);

    void delete(List<String> keys);

    boolean update(User user);

    User get(String keyId);
}
