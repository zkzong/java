package com.zkzong.sb.dubbo.api.service.impl;

import com.zkzong.sb.dubbo.api.service.ComputeService;
import org.springframework.stereotype.Service;

/**
 * Created by Zong on 2017/5/12.
 */
@Service("computeService")
public class ComputeServiceImpl implements ComputeService {
    @Override
    public Integer add(int a, int b) {
        return a + b;
    }
}
