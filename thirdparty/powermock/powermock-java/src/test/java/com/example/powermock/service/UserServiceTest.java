package com.example.powermock.service;

import com.example.powermock.common.User;
import com.example.powermock.dao.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserDao userDao;

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
    public void queryUserCountWithMockito() {
        MockitoAnnotations.initMocks(this);

        UserService service = new UserService(userDao);
        Mockito.when(userDao.getCount()).thenReturn(10);

        int result = service.queryUserCount();
        assertEquals(10, result);
    }

    @Test
    public void queryUserCountWithPowerMock() {
        UserDao uDao = PowerMockito.mock(UserDao.class);
        //PowerMockito.doReturn(10).when(uDao).getCount();
        PowerMockito.when(uDao.getCount()).thenReturn(10);

        UserService service = new UserService(uDao);
        int result = service.queryUserCount();
        assertEquals(10, result);
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