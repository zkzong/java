package org.example.mongo.repository;

import org.example.mongo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @Author: Zong
 * @Date: 2019/3/20
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("zong");
        user.setCreateTime(new Date());
        userRepository.insert(user);
    }

    @Test
    public void findByUsername() {
        User user = userRepository.findByUsername("zong");
        System.out.println(user);
    }

    @Test
    public void findUsersByUsername() {
        List<User> users = userRepository.findUsersByUsername("zong");
        System.out.println(users);
    }

}