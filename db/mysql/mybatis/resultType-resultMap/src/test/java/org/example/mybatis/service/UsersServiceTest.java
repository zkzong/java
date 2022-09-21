package org.example.mybatis.service;

import org.example.mybatis.domain.Users;
import org.example.mybatis.mapper.UsersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersServiceTest {

    @Autowired
    private UsersMapper usersMapper;

    @Test
    public void getUserName() {
        List<String> names = usersMapper.getUserName();
        System.out.println(names);
    }

    @Test
    public void getUsersMap() {
        List<Users> users = usersMapper.getUsersMap();
        System.out.println(users);
    }

    @Test
    public void getUsersType() {
        List<Users> users = usersMapper.getUsersType();
        System.out.println(users);
    }
}