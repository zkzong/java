package com.example.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mp.entity.TUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zkzong
 * @Date: 2018.9.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        TUser user = new TUser();
        user.setUserName("小羊");
        user.setAge(3);
        user.setEmail("abc@mp.com");
        Assert.assertTrue(userMapper.insert(user) > 0);
        // 成功直接拿会写的 ID
        System.err.println("插入成功 ID 为：" + user.getId());
    }

    @Test
    public void query() {
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "Tom");
        TUser tUser = userMapper.selectOne(wrapper);
        System.out.println(tUser);
    }

    @Test
    public void updateById() {
        TUser user = new TUser();
        user.setId(1225251937926959106L);
        //user.setUserName("小羊");
        user.setAge(4);
        //user.setEmail("abc@mp.com");
        Assert.assertTrue(userMapper.updateById(user) > 0);
        // 成功直接拿会写的 ID
        System.err.println("更新成功 ID 为：" + user.getId() + " 的数据");
    }

    @Test
    public void deleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", "小羊");
        userMapper.deleteByMap(map);
    }
}
