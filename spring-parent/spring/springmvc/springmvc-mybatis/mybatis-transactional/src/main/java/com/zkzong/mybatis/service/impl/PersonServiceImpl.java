package com.zkzong.mybatis.service.impl;

import com.zkzong.mybatis.mapper.PersonMapper;
import com.zkzong.mybatis.mapper.UserMapper;
import com.zkzong.mybatis.service.PersonService;
import com.zkzong.mybatis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zong on 17-5-31.
 */
@Service
public class PersonServiceImpl implements PersonService {
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PersonMapper personMapper;

    @Override
    public int insertPerson(String name, int age) {
        return personMapper.insertPerson(name, age);
    }
}
