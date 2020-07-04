package com.zkzong.sb.logback.service.impl;

import com.zkzong.sb.logback.entity.User;
import com.zkzong.sb.logback.mapper.UserMapper;
import com.zkzong.sb.logback.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Zong
 * @Date: 2018/12/18
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUsersByName(String name) {
        log.info("Service查询参数name = {}", name);
        List<User> userList = userMapper.findUsersByName(name);
        return userList;
    }
}
