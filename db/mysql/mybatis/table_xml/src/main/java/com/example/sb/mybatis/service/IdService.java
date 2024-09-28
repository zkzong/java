package com.example.sb.mybatis.service;

import com.example.sb.mybatis.domain.Users;

/**
 * @Author: zongz
 * @Date: 2024/9/24
 */
public interface IdService {

    int useGeneratedKeys(Users users);

    int insertselectkey(Users users);

    int insertSelectKey(Users users);

    int insertOptions(Users users);

}
