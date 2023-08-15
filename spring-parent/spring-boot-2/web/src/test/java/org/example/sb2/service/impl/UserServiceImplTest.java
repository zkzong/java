package com.example.sb2.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.sb2.dto.A;
import com.example.sb2.dto.B;
import com.example.sb2.entity.User;
import com.example.sb2.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author: Zong
 * @Date: 2018/12/8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void findAll() {
        List<User> userList = userService.findAll();
        System.out.println(userList);
    }

    @Test
    public void save() {
        User user = new User();
        user.setName("hehe");
        user.setAge(10);
        User u = userService.save(user);
        System.out.println(u);
        List<User> userList = userService.findAll();
        System.out.println(userList);
    }

    @Test
    public void test() {
        A<B> ab = new A<>();

        B b = new B();
        b.setName("zong");
        ab.setT(b);
        System.out.println(JSON.toJSONString(ab));
    }
}
