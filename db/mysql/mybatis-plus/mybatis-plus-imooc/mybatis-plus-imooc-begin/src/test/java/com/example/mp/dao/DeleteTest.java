package com.example.mp.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.mp.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void deleteById() {
        int rows = userMapper.deleteById(1201791917851521025L);
        System.out.println("删除条数：" + rows);
    }

    @Test
    public void deleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "刘明强");
        map.put("age", 31);
        int rows = userMapper.deleteByMap(map);
        System.out.println("删除条数：" + rows);
    }

    @Test
    public void deleteByIds() {
        int rows = userMapper.deleteBatchIds(Arrays.asList(1201793087185637378L, 1201793128482791426L));
        System.out.println("删除条数：" + rows);
    }

    @Test
    public void deleteByWrapper() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.<User>lambdaQuery();
        lambdaQueryWrapper.eq(User::getAge, 21);
        int rows = userMapper.delete(lambdaQueryWrapper);
        System.out.println("删除条数：" + rows);
    }

}
