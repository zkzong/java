package com.zkzong.sb.repository;

import com.zkzong.sb.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zkzong
 * @Date: 2018.10.31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserJpaRepositoryTest {
    @Autowired
    private UserJpaRepository userJpaRepository;

    @Test
    public void add() {
        User user = new User();
        user.setId(1L);
        user.setName("zong");
        user.setPassword("zong");
        userJpaRepository.save(user);
    }

    @Test
    public void findByName() {
        User user = userJpaRepository.findByName("zong");
        System.out.println(user);
    }

    @Test
    public void batchDelete() {
        List<User> userList = new ArrayList<>(8);
        User user1 = new User();
        user1.setId(1L);
        user1.setName("zong");
        userList.add(user1);
        User user2 = new User();
        user2.setId(2L);
        user2.setName("ma");
        userList.add(user2);
        userJpaRepository.deleteInBatch(userList);
    }
}