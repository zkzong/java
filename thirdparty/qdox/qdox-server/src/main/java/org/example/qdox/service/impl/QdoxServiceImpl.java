package org.example.qdox.service.impl;

import org.example.qdox.mapper.UserMapper;
import org.example.qdox.service.QdoxService;
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
