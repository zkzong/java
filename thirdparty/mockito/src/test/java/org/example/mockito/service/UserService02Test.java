package com.example.mockito.service;

import com.example.mockito.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserService02Test {

    @Mock
    private UserService userService;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test02() {
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