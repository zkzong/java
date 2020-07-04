package com.zkzong.mybatis.mapper;

import com.zkzong.mybatis.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Zong on 2017/5/31.
 */
public interface UserMapper {

    int insertUser(@Param("name") String name, @Param("age") int age);

}
