package com.example.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.mp.dao.UserMapper;
import com.example.mp.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OptTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void updateById() {
        int version = 1;
        User user = new User();
        user.setId(1245310743952191490L);
        user.setEmail("lmc2@baomidou.com");
        user.setVersion(version);
        int rows = userMapper.updateById(user);
        System.out.println("影响行数：" + rows);
    }

    @Test
    public void update() {
        int version = 2;

        User user = new User();
        user.setEmail("lmc3@baomidou.com");
        user.setVersion(version);

        QueryWrapper<User> query = Wrappers.<User>query();
        query.eq("name", "刘明超");

        int rows = userMapper.update(user, query);
        System.out.println("影响行数：" + rows);

        int version2 = 3;
        User user2 = new User();
        user2.setEmail("lmc3@baomidou.com");
        user2.setVersion(version2);

        // QueryWrapper 不能复用
        query.eq("age", 31);

        int rows2 = userMapper.update(user2, query);
        System.out.println("影响行数：" + rows2);
    }
}
