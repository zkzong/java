package com.example.sb.mybatis.mapper;

import com.example.sb.mybatis.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectKey;

/**
 * @Author: zongz
 * @Date: 2024/9/24
 */
@Mapper
public interface IdMapper {

    int insertUseGeneratedKeys(Users users);

    int insertselectkey(Users users);

    @Insert("insert into t_users(user_name,age) values(#{userName},#{age})")
    @SelectKey(statement = "select last_insert_id() from dual", before = false, resultType = Long.class, keyColumn = "id", keyProperty = "id")
    int insertSelectKey(Users users);

    @Insert("insert into t_users(user_name,age) values(#{userName},#{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertOptions(Users users);

}
