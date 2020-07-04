package com.zkzong.sb.mybatis.service;

import com.zkzong.sb.mybatis.domain.Users;

import java.util.List;

/**
 * Created by Zong on 2017/6/1.
 */
public interface UsersService {

    List<Users> getAllUsers();

    Users findByName(String name);

    void insertOne(String name, int age);

}
