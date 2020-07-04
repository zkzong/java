package com.zkzong.tx.service.impl;

import com.zkzong.tx.mapper.PersonMapper;
import com.zkzong.tx.mapper.UserMapper;
import com.zkzong.tx.service.TxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Zong
 * @Date: 2018/11/14
 */
@Service
public class TxServiceImpl implements TxService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PersonMapper personMapper;

    @Transactional
    @Override
    public void insertAll(String name, int age) {
        userMapper.insertUser(name, age);
        //try {
        //    throw new Exception();
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        int i = 1/0;
        personMapper.insertPerson(name, age);
    }
}
