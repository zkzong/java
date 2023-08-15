package com.example.sb.pagehelper;

import com.github.pagehelper.PageInfo;
import com.example.sb.pagehelper.domain.Users;
import com.example.sb.pagehelper.domain.UsersDto;
import com.example.sb.pagehelper.service.UsersService;
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

    @Test
    public void insert() {
        for (int i = 0; i < 100; i++) {
            Users users = new Users();
            users.setName(i + "");
            users.setAge(i);
            usersService.insert(users);
        }
    }

    // todo
    @Test
    public void list() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    List<Users> allUsers = usersService.list();
                    System.out.println(allUsers);
                }
            });
            Thread.sleep(1000);
        }

    }

    @Test
    public void page() {
        UsersDto dto = new UsersDto();
        dto.setPageNum(1);
        dto.setPageSize(3);
        PageInfo<Users> page = usersService.page(dto);
        System.out.println(page);
    }

}
