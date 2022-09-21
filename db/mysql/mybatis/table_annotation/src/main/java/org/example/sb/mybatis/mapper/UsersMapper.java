package org.example.sb.mybatis.mapper;

import org.example.sb.mybatis.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Zong on 2017/6/1.
 */
@Mapper
public interface UsersMapper {
    @Select("select * from t_users")
    List<Users> getAllUsers();

    @Select("select * from t_users where user_name = #{name}")
    Users findByName(String name);

    @Insert("insert into t_users(user_name, age) values(#{name}, #{age})")
    void insertOne(@Param("name") String name, @Param("age") int age);
}
