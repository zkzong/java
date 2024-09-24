package com.example.sb.mybatis.service.impl;

import com.example.sb.mybatis.domain.Users;
import com.example.sb.mybatis.mapper.IdMapper;
import com.example.sb.mybatis.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zongz
 * @Date: 2024/9/24
 */
@Service
public class IdServiceImpl implements IdService {

    @Autowired
    private IdMapper idMapper;

    @Override
    public int useGeneratedKeys(Users users) {
        return idMapper.useGeneratedKeys(users);
    }

    @Override
    public int selectkey(Users users) {
        return idMapper.selectkey(users);
    }
}
