package com.example.tx.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Zong on 2017/6/1.
 */
@Mapper
public interface UserMapper {

    @Insert("insert into t_user(name, age) values(#{name}, #{age})")
    void insertUser(@Param("name") String name, @Param("age") int age);

}
