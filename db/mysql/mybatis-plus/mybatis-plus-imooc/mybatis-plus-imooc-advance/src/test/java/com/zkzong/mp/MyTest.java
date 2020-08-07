package com.zkzong.mp;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zkzong.mp.dao.UserMapper;
import com.zkzong.mp.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteById() {
        int rows = userMapper.deleteById(1094592041087729666L);
        System.out.println("影响行数：" + rows);
    }

    @Test
    public void select() {
        // MybatisPlusConfig.myTableName.set("user");
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void updateById() {
        User user = new User();
        user.setId(1088248166370832385L);
        user.setAge(27);
        int rows = userMapper.updateById(user);
        System.out.println("影响行数：" + rows);
    }

    /**
     * 自定义语句，逻辑删除不起作用
     */
    @Test
    public void mySelect() {
        List<User> userList = userMapper.mySelectList(Wrappers.<User>lambdaQuery().gt(User::getAge, 25).eq(User::getDeleted, 0));
        userList.forEach(System.out::println);
    }

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
    public void selectById() {
        User user = userMapper.selectById(1088248166370832385L);
        System.out.println(user);
    }
}
