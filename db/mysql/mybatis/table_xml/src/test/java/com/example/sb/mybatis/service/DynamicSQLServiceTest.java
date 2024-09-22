package com.example.sb.mybatis.service;

import com.example.sb.mybatis.domain.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zongz
 * @Date: 2024/9/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicSQLServiceTest {

    @Autowired
    private DynamicSQLService dynamicSQLService;

    @Test
    public void foreach() {
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        List<Users> foreach = dynamicSQLService.foreach(ids);
        System.out.println(foreach);
    }

    @Test
    public void where() {
        Users users = new Users();
        users.setUserName("1");
        users.setAge(1);
        Users trim = dynamicSQLService.where(users);
        System.out.println(trim);
    }

    @Test
    public void trim() {
        Users users = new Users();
        users.setUserName("1");
        users.setAge(1);
        Users trim = dynamicSQLService.trim(users);
        System.out.println(trim);
    }

    @Test
    public void triminsert() {
        Users users = new Users();
        users.setUserName("1");
        users.setAge(1);
        int triminsert = dynamicSQLService.triminsert(users);
        System.out.println(triminsert);
    }

    @Test
    public void bind() {
        Long id = 1L;
        Users bind = dynamicSQLService.bind(id);
        System.out.println(bind);
    }
}
