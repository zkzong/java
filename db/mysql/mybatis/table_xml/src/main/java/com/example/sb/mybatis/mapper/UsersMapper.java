package com.example.sb.mybatis.mapper;

import com.example.sb.mybatis.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2017/6/1.
 */
@Mapper
public interface UsersMapper {

    List<Users> getAllUsers();

    Users findByUserName(String userName);

    void insertOne(@Param("userName") String userName, @Param("age") int age);

    int insertBatch(@Param("userlist") List<Users> userList);

    int insertAndGetId(Users users);

    Users findByIndex(String userName, int age);

    Users findByMap(Map map);

    Users findByParam(@Param("userName") String userName, @Param("age") int age);

    List<Users> namein(@Param("names") List<String> names, @Param("name") String name);

}
