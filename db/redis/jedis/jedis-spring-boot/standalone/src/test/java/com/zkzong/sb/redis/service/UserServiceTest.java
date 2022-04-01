package com.zkzong.sb.redis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void findAllUser() {
        userService.findAllUser();
    }

    @Test
    public void redisMap() {
        userService.redisMap();
    }

    @Test
    public void cacheOne() {
        userService.cacheOne(1);
    }

    @Test
    public void cacheOne2() {
        userService.cacheOne2(1);
    }

    @Test
    public void cacheOne3() {
        userService.cacheOne3(1);
    }

    @Test
    public void cacheOne4() {
        userService.cacheOne4(1);
    }

    @Test
    public void cacheOne5() {
        userService.cacheOne5(1);
    }

    @Test
    public void del() {
        userService.del(1);
    }

    @Test
    public void testDel() {
    }

    @Test
    public void cacheList() {
        userService.cacheList();
    }

    @Test
    public void cacheList2() {
        userService.cacheList2();
    }
}