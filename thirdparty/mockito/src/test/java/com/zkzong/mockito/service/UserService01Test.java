package com.zkzong.mockito.service;

import com.zkzong.mockito.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.mockito.Mockito.*;

@SpringBootTest
public class UserService01Test {

    private UserService userService;

    @BeforeEach
    public void before() {
        userService = mock(UserService.class);
    }

    @Test
    public void test01() {
        User user = new User();
        user.setId(1L);
        user.setUserName("ma");
        user.setAge(20);
        user.setAddress("xc");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        when(userService.selectById(1L)).thenReturn(user);
        System.out.println(userService.selectById(1L).getUserName());
        verify(userService).selectById(1L);
    }

}