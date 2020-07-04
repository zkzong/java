package com.zkzong.mybatis.pagehelper.service;

import com.github.pagehelper.PageInfo;
import com.zkzong.mybatis.pagehelper.domain.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Zong on 2017/5/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class UsersServiceTest {
    @Autowired
    private UsersService usersService;

    @Test
    public void getAllUsers() throws Exception {
        List<Users> allUsers = usersService.getAllUsers();
        System.out.println(allUsers);
    }

    @Test
    public void getUsersByPage() throws Exception {
        PageInfo<Users> page = usersService.getUsersByPage();
        System.out.println(page);
    }

}
