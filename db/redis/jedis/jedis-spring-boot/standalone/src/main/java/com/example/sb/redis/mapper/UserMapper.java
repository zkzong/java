package com.example.sb.redis.mapper;

import com.example.sb.redis.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();

    User findById(Integer id);
}
