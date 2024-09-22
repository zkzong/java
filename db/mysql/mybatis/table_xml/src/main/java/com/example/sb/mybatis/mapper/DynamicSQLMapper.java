package com.example.sb.mybatis.mapper;

import com.example.sb.mybatis.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zongz
 * @Date: 2024/9/22
 */
@Mapper
public interface DynamicSQLMapper {

    List<Users> foreach(@Param("ids") List<Long> ids);

    Users where(Users users);

    Users trim(Users Users);

    int triminsert(Users users);

    Users bind(@Param("id") Long id);
}
