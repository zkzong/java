package com.zkzong.dubbo.simple.provider;

import com.zkzong.dubbo.simple.DemoService;
import com.zkzong.dubbo.simple.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zong on 2016/11/24.
 * 在服务提供方实现接口：(对服务消费方隐藏实现)
 */
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello " + name;
    }

    public List getUsers() {
        List list = new ArrayList();
        User u1 = new User();
        u1.setName("jack");
        u1.setAge(20);
        u1.setSex("男");

        User u2 = new User();
        u2.setName("tom");
        u2.setAge(21);
        u2.setSex("女");

        User u3 = new User();
        u1.setName("rose");
        u1.setAge(19);
        u1.setSex("女");

        list.add(u1);
        list.add(u2);
        list.add(u3);
        return list;
    }
}
