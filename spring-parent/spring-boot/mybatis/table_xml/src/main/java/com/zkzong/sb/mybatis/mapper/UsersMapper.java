package com.zkzong.sb.mybatis.mapper;

import com.zkzong.sb.mybatis.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Zong on 2017/6/1.
 */
@Mapper
public interface UsersMapper {

    List<Users> getAllUsers();

    Users findByUserName(String userName);

    void insertOne(@Param("userName") String userName, @Param("age") int age);

}
