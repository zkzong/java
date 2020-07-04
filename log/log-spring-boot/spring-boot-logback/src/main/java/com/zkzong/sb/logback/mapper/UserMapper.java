package com.zkzong.sb.logback.mapper;

import com.zkzong.sb.logback.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Zong
 * @Date: 2018/12/18
 */
@Mapper
public interface UserMapper {
    List<User> findUsersByName(String name);
}
