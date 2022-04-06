package com.zkzong.sb.mybatis.controller;

import com.zkzong.sb.mybatis.domain.Users;
import com.zkzong.sb.mybatis.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/insert")
    public String insert(@RequestBody Users users) {
        usersService.insertAndGetId(users);
        return "success";
    }
}
