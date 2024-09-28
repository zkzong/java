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
        return idMapper.insertUseGeneratedKeys(users);
    }

    @Override
    public int insertselectkey(Users users) {
        return idMapper.insertselectkey(users);
    }

    @Override
    public int insertSelectKey(Users users) {
        return idMapper.insertSelectKey(users);
    }

    @Override
    public int insertOptions(Users users) {
        return idMapper.insertOptions(users);
    }
}
