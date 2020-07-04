package com.zkzong.mp.service;

import com.github.pagehelper.PageInfo;
import com.zkzong.mp.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void query() {
        PageInfo<User> users = userService.query(null);
        System.out.println(users);
    }

    @Test
    public void saveOrUpdate() {
        User user = new User();
        user.setId(4L);
        user.setUserName("test");
        user.setAge(11);
        user.setAddress("bj");
        userService.saveOrUpdate(user);
    }
}