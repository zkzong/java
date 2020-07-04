package com.zkzong.sb.pagehelper;

import com.github.pagehelper.PageInfo;
import com.zkzong.sb.pagehelper.domain.Users;
import com.zkzong.sb.pagehelper.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Zong on 2017/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PageHelperApplicationTest {
    @Autowired
    private UsersService usersService;

    // todo
    @Test
    public void getAllUsers() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    List<Users> allUsers = usersService.getAllUsers();
                    System.out.println(allUsers);
                }
            });
            Thread.sleep(1000);
        }

    }

    @Test
    public void getUsersByPage() {
        PageInfo<Users> page = usersService.getUsersByPage();
        System.out.println(page);
    }
}