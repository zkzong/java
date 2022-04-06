package com.zkzong.sb.mybatis.service;

import com.zkzong.sb.mybatis.domain.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2017/6/1.
 */
public interface UsersService {

    List<Users> getAllUsers();

    Users findByUserName(String userName);

    void insertOne(String userName, int age);

    int insertAndGetId(Users users);

    Users findByIndex(String userName, int age);

    Users findByMap(Map map);

    Users findByParam(@Param("userName") String userName, @Param("age") int age);

}
