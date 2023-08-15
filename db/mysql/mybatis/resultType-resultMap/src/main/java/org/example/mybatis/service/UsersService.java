package com.example.mybatis.service;


import com.example.mybatis.domain.Users;

import java.util.List;

/**
 * Created by Zong on 2017/6/1.
 */
public interface UsersService {

    List<String> getUserName();

    List<Users> getUsersMap();

    List<Users> getUsersType();

}
