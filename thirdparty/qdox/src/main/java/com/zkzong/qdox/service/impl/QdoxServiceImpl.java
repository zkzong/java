package com.zkzong.qdox.service.impl;

import com.zkzong.qdox.service.QdoxService;
import org.springframework.stereotype.Service;

/**
 * @Author: zong
 * @Date: 2021/11/25
 */
@Service
public class QdoxServiceImpl implements QdoxService {
    @Override
    public String getQdox() {
        return "qdox";
    }
}
