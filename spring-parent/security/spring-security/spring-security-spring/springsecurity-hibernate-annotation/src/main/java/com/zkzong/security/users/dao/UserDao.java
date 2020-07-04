package com.zkzong.security.users.dao;

import com.zkzong.security.users.model.Users;

public interface UserDao {

    Users findByUserName(String username);

}