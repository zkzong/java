package com.zkzong.sb2.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.zkzong.sb2.api.DemoService;

@Service(version = "${demo.service.version}", group = "${demo.service.group}")
public class DefaultDemoService implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }

}