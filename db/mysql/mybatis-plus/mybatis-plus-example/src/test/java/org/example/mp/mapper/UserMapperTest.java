package org.example.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.mp.entity.TUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: zkzong
 * @Date: 2018.9.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectAll() {
        System.out.println(("----- selectAll method test ------"));
        List<TUser> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectById() {
        System.out.println(("----- selectAll method test ------"));
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<TUser>();
        //User user = new User();
        //user.setId(1L);
        //queryWrapper.setEntity(user);
        queryWrapper.eq("id", 1);
        List<TUser> userList = userMapper.selectList(queryWrapper);
        Assert.assertEquals(1, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void getUserById() {
        TUser user = userMapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void getById() {
        TUser user = userMapper.getById(1);
        System.out.println(user);
    }

    @Test
    public void deleteById() {
        TUser user = new TUser();
        user.setId(1L);
        userMapper.deleteById(user);
    }

    @Test
    public void deleteById2() {
        int id = 2;
        // 3.0.1 必须转换成Long，否则报错，3.0.6不用转换
        //Long lid = Long.valueOf(id);
        userMapper.deleteById(id);
    }

    @Test
    public void updateById() {
        TUser user = new TUser();
        user.setId(3L);
        user.setUserName("aishasha");
        userMapper.updateById(user);
    }

    @Test
    public void selectList() {
        List<TUser> userList = userMapper.selectList(null);
        System.out.println(userList);
    }

}