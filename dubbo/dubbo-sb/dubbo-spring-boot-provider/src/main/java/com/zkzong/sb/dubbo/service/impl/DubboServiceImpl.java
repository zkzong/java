package com.zkzong.sb.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zkzong.sb.dubbo.api.DubboService;

@Service(version = "1.0.0")
public class DubboServiceImpl implements DubboService {
    @Override
    public void sayHello(String name) {
        System.out.println(name);
        System.out.println("---dubbo 发布服务----");
    }
}
