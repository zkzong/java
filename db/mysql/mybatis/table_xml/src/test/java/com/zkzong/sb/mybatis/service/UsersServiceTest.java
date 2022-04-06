package com.zkzong.sb.mybatis.service;

import com.zkzong.sb.mybatis.domain.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersServiceTest {

    @Autowired
    private UsersService usersService;

    @Test
    public void getAllUsers() {
        List<Users> allUsers = usersService.getAllUsers();
        System.out.println(allUsers);
    }

    @Test
    public void findByUserName() {
        Users users = usersService.findByUserName("m");
        System.out.println(users);
    }

    @Test
    public void insertOne() {
        usersService.insertOne("m", 22);
    }

    @Test
    public void findByIndex() {
        Users user = usersService.findByIndex("zong", 30);
        System.out.println(user);
    }

    @Test
    public void findByMap() {
        Map map = new HashMap();
        map.put("userName", "zong");
        map.put("age", 30);
        Users user = usersService.findByMap(map);
        System.out.println(user);
    }

    @Test
    public void findByParam() {
        Users user = usersService.findByParam("zong", 30);
        System.out.println(user);
    }
}