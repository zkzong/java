package org.example.mp;

import org.example.mp.dao.UserMapper;
import org.example.mp.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FillTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setName("刘明超");
        user.setAge(31);
        user.setEmail("lmc@baomidou.com");
        user.setManagerId(1088248166370832385L);
        int rows = userMapper.insert(user);
        System.out.println("影响行数：" + rows);
    }

    @Test
    public void updateById() {
        User user = new User();
        user.setId(1088248166370832385L);
        user.setAge(27);
        int rows = userMapper.updateById(user);
        System.out.println("影响行数：" + rows);
    }

}
