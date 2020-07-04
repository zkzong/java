package com.zkzong.mybatis.pagehelper.mapper;

import com.zkzong.mybatis.pagehelper.domain.Users;

import java.util.List;

/**
 * Created by Zong on 2017/5/31.
 */
public interface UsersMapper {
    Users findUsersById(Integer id);

    List<Users> getAllUsers();

}
