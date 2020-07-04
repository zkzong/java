package com.zkzong.mybatis.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * Created by Zong on 2017/5/31.
 */
public interface PersonMapper {

    int insertPerson(@Param("name") String name, @Param("age") int age);

}
