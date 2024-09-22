package com.example.sb.mybatis.service;

import com.example.sb.mybatis.domain.Users;

import java.util.List;

/**
 * @Author: zongz
 * @Date: 2024/9/22
 */
public interface DynamicSQLService {

    List<Users> foreach(List<Long> ids);

    Users where(Users users);

    Users trim(Users users);

    int triminsert(Users users);

    Users bind(Long id);
}
