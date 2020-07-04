package com.zkzong.sb.logback.service;

import com.zkzong.sb.logback.entity.User;

import java.util.List;

/**
 * @Author: Zong
 * @Date: 2018/12/18
 */
public interface UserService {
    List<User> findUsersByName(String name);
}
