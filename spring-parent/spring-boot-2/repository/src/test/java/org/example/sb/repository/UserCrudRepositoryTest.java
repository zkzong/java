package com.example.sb.repository;

import com.example.sb.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: zkzong
 * @Date: 2018.10.31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCrudRepositoryTest {
    @Autowired
    private UserCrudRepository userCrudRepository;

    @Test
    public void add() {
        User user = new User();
        user.setId(2L);
        user.setName("ma");
        user.setPassword("ma");
        userCrudRepository.save(user);
    }

    @Test
    public void findByName() {
        User user = userCrudRepository.findByName("zong");
        System.out.println(user);
    }

}