package com.example.sb.mybatis.service;

import com.example.sb.mybatis.domain.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: zongz
 * @Date: 2024/9/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IdServiceTest {

    @Autowired
    private IdService idService;

    @Test
    public void useGeneratedKeys() {
        Users users = new Users();
        users.setUserName("1");
        users.setAge(1);
        int useGeneratedKeys = idService.useGeneratedKeys(users);
        System.out.println(useGeneratedKeys);
        System.out.println(users.getId());
    }

    @Test
    public void selectkey() {
        Users users = new Users();
        users.setUserName("1");
        users.setAge(1);
        int selectkey = idService.selectkey(users);
        System.out.println(selectkey);
        System.out.println(users.getId());
    }

}
