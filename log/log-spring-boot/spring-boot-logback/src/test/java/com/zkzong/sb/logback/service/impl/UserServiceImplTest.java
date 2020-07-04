package com.zkzong.sb.logback.service.impl;

import com.zkzong.sb.logback.entity.User;
import com.zkzong.sb.logback.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void findUsersByName() {
        List<User> userList = userService.findUsersByName("mo");
        Assert.assertEquals(1, userList.size());
    }
}