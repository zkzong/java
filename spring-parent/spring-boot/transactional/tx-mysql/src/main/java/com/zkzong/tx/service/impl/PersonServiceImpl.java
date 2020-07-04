package com.zkzong.tx.service.impl;

import com.zkzong.tx.mapper.PersonMapper;
import com.zkzong.tx.mapper.UserMapper;
import com.zkzong.tx.service.PersonService;
import com.zkzong.tx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Zong on 2017/6/1.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public void insertPerson(String name, int age) {
        personMapper.insertPerson(name, age);
    }

}
