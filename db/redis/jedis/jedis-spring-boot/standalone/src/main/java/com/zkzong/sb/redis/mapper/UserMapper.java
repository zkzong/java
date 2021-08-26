package com.zkzong.sb.redis.mapper;

import com.zkzong.sb.redis.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();

}
