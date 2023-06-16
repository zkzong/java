package org.example.tx.service.impl;

import org.example.tx.mapper.PersonMapper;
import org.example.tx.service.PersonService;
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
