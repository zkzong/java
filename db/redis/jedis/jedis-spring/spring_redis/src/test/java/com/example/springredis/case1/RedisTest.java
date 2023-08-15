package com.example.springredis.case1;

import com.example.springredis.case1.dao.IUserDao;
import com.example.springredis.case1.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zong on 2017/3/2.
 */
public class RedisTest {
    private IUserDao userDao;

    @Before
    public void init() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("case1/applicationContext.xml");
        userDao = (IUserDao) ctx.getBean("userDao");
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setId("B");
        user.setName("B");
        boolean result = userDao.add(user);
        Assert.assertTrue(result);
    }

    @Test
    public void testDelete() {
        String key = "B";
        User user = userDao.get(key);
        System.out.println("删除前：" + user);
        userDao.delete(key);
        user = userDao.get(key);
        System.out.println("删除后：" + user);
    }
}
