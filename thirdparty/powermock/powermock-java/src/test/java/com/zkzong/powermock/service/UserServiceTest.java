package com.zkzong.powermock.service;

import com.zkzong.powermock.common.User;
import com.zkzong.powermock.dao.UserDao;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void before() {
        userService = new UserService(new UserDao());
    }

    @Test
    public void queryUserCountWithJunit() {
        //int count = userService.queryUserCount();
        //assertEquals(0, count);
        try {
            userService.queryUserCount();
            fail("should not process to here.");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }

    @Test
    public void saveUserWithJunit() {
        //userService.saveUser(new User());
        try {
            userService.saveUser(new User());
            fail("should not process to here.");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }
}