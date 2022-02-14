package com.zkzong.sb2.service;

import com.zkzong.sb2.entity.User;

import java.util.List;

/**
 * @Author: Zong
 * @Date: 2018/12/8
 */
public interface UserService {
    List<User> findAll();

    User save(User user);
}
