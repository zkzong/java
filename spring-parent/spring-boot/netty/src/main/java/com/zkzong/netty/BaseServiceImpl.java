package com.zkzong.netty;

import org.springframework.stereotype.Service;

/**
 * @Author: zong
 * @Date: 2020/1/13
 */
@Service
public class BaseServiceImpl implements BaseService {
    @Override
    public void test() {
        System.out.println("调用service服务");
    }
}
