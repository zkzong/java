package com.zkzong.tx.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Zong on 2017/6/1.
 */
@Mapper
public interface PersonMapper {

    @Insert("insert into t_person(name, age) values(#{name}, #{age})")
    void insertPerson(@Param("name") String name, @Param("age") int age);

}
