package org.example.springboot.jdbc.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Zong on 2017/4/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
        userService.deleteAllUsers();
    }

    @Test
    public void test() {
        userService.create("a", 1);
        userService.create("b", 2);
        userService.create("c", 3);
        userService.create("d", 4);
        userService.create("e", 5);

        Assert.assertEquals(5, userService.getAllUsers().intValue());

        userService.deleteByName("a");
        userService.deleteByName("e");

        Assert.assertEquals(3, userService.getAllUsers().intValue());
    }
}