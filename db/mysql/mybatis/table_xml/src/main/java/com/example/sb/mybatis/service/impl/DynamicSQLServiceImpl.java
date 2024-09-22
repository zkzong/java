package com.example.sb.mybatis.service.impl;

import com.example.sb.mybatis.domain.Users;
import com.example.sb.mybatis.mapper.DynamicSQLMapper;
import com.example.sb.mybatis.service.DynamicSQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zongz
 * @Date: 2024/9/22
 */
@Service
public class DynamicSQLServiceImpl implements DynamicSQLService {

    @Autowired
    private DynamicSQLMapper dynamicSQLMapper;

    @Override
    public List<Users> foreach(List<Long> ids) {
        return dynamicSQLMapper.foreach(ids);
    }

    @Override
    public Users where(Users users) {
        return dynamicSQLMapper.where(users);
    }

    @Override
    public Users trim(Users users) {
        return dynamicSQLMapper.trim(users);
    }

    @Override
    public int triminsert(Users users) {
        return dynamicSQLMapper.triminsert(users);
    }

    @Override
    public Users bind(Long id) {
        return dynamicSQLMapper.bind(id);
    }
}
