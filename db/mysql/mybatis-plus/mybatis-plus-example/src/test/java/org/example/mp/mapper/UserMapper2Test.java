package org.example.mp.mapper;

import org.example.mp.entity.TUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: zkzong
 * @Date: 2018.9.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapper2Test {

    @Autowired
    private UserMapper2 userMapper2;

    @Test
    public void getUserById() {
        TUser user = userMapper2.getUserById(1);
        System.out.println(user);
    }

}