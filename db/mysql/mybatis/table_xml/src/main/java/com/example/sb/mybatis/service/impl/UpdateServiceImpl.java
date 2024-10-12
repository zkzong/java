package com.example.sb.mybatis.service.impl;

import com.example.sb.mybatis.mapper.UpdateMapper;
import com.example.sb.mybatis.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    private UpdateMapper updateMapper;

    @Override
    public Integer update() {
        return updateMapper.update();
    }

    @Override
    public Integer updateRows() {
        return updateMapper.updateRows();
    }
}
