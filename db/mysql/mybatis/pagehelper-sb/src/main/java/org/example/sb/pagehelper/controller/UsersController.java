package com.example.sb.pagehelper.controller;

import com.github.pagehelper.PageInfo;
import com.example.sb.pagehelper.domain.Users;
import com.example.sb.pagehelper.domain.UsersDto;
import com.example.sb.pagehelper.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Resource
    private UsersService usersService;

    @GetMapping("/page")
    public PageInfo<Users> page(@RequestBody UsersDto param) {
        return usersService.page(param);
    }

}
