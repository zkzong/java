package com.zkzong.sb.mybatis;

import com.zkzong.sb.mybatis.domain.Users;
import com.zkzong.sb.mybatis.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TableXmlApplicationTest {

    @Autowired
    private UsersService usersService;

    @Test
    public void getAllUsers() {
        List<Users> allUsers = usersService.getAllUsers();
        System.out.println(allUsers);
    }

    @Test
    public void findByName() {
        Users users = usersService.findByUserName("m");
        System.out.println(users);
    }

    @Test
    public void insertOne() {
        usersService.insertOne("m", 22);
    }

}