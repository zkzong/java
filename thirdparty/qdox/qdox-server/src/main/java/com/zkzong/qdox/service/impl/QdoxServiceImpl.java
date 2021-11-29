package com.zkzong.qdox.service.impl;

import com.zkzong.qdox.mapper.UserMapper;
import com.zkzong.qdox.service.QdoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zong
 * @Date: 2021/11/25
 */
@Service
public class QdoxServiceImpl implements QdoxService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String getQdox() {
        return "qdox";
    }

    @Override
    public String getName() {
        userMapper.save();
        return "";
    }

}
