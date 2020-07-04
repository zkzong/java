package com.zkzong.redis;

import com.zkzong.redis.dao.UserDAO;
import com.zkzong.redis.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Zong on 2017/2/17.
 */
public class RedisExample {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/redis/applicationContext.xml");
        UserDAO userDAO = (UserDAO) ac.getBean("userDAO");
        User user1 = new User();
        user1.setId(1);
        user1.setName("zzk");
        userDAO.saveUser(user1);
        User user2 = userDAO.getUser(1);
        System.out.println(user2.getName());
    }
}
