package com.example.mockito.service;

import com.example.mockito.entity.User;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
@SpringBootTest
public class UserService04Test {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    private UserService userService;

    @Test
    public void test04() {
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