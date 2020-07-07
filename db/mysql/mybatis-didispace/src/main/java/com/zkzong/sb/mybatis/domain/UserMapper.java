package com.zkzong.sb.mybatis.domain;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Zong on 2017/4/25.
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{name}")
    User findByName(String name);

    // 两个参数必须加@Param注解
    @Select("select * from user where name = #{name} and age = #{age}")
    User findByNameAndAge(@Param("name") String name, @Param("age") Integer age);

    @Insert("insert into user(name, age) values(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

}
