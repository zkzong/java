package com.zkzong.sb.controller;

import com.zkzong.sb.pojo.User;
import com.zkzong.sb.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zong
 * @Date: 2019.1.14
 */
@RestController
public class TestController {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @RequestMapping(value = "/insert")
    public String insert() {
        User user = new User();
        user.setName("zong");
        user.setPassword("zong");
        userJpaRepository.save(user);
        return "success";
    }

    @RequestMapping(value = "/delete")
    public String delete() {
        userJpaRepository.delete(1L);
        return "success";
    }
}
