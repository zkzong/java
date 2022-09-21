package org.example.sb.mybatis.service;

import org.example.sb.mybatis.domain.Users;
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

    int insertBatch(List<Users> userList);

    int insertAndGetId(Users users);

    Users findByIndex(String userName, int age);

    Users findByMap(Map map);

    Users findByParam(@Param("userName") String userName, @Param("age") int age);

    List<Users> namein(List<String> names, String name);

}
