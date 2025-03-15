package com.example.springredis.case1;

import com.example.springredis.case1.dao.IUserDao;
import com.example.springredis.case1.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zong on 2017/3/2.
 */
@ContextConfiguration(locations = {"classpath:case1/applicationContext.xml"})
public class RedisSpringTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    private IUserDao userDao;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setId("user");
        user.setName("zong");
        boolean result = userDao.add(user);
        Assert.assertTrue(result);
    }

    /**
     * 批量新增 普通方式
     */
    @Test
    public void testAddUserList1() {
        List<User> list = new ArrayList<User>();
        for (int i = 100000; i < 200000; i++) {
            User user = new User();
            user.setId("user" + i);
            user.setName("zong" + i);
            list.add(user);
        }
        long begin = System.currentTimeMillis();
        for (User user : list) {
            userDao.add(user);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    /**
     * 批量新增 pipeline方式
     */
    @Test
    public void testAddUserList2() {
        List<User> list = new ArrayList<User>();
        for (int i = 300000; i < 400000; i++) {
            User user = new User();
            user.setId("user" + i);
            user.setName("zong" + i);
            list.add(user);
        }
        long begin = System.currentTimeMillis();
        boolean result = userDao.add(list);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
        Assert.assertTrue(result);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId("user1");
        ;
        user.setName("zzzzzz");
        boolean result = userDao.update(user);
        Assert.assertTrue(result);
    }

    @Test
    public void testDelete() {
        String key = "user1";
        userDao.delete(key);
    }

    @Test
    public void testDeletes() {
        List<String> list = new ArrayList<String>();
        for (int i = 300000; i < 400000; i++) {
            list.add("user" + i);
        }
        userDao.delete(list);
    }

    @Test
    public void testGet() {
        String key = "user2";
        User user = userDao.get(key);
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getName(), "zong");
    }

}
