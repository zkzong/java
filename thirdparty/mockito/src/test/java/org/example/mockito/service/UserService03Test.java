package org.example.mockito.service;

import org.example.mockito.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserService03Test {

    @Mock
    private UserService userService;

    @Test
    public void test03() {
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