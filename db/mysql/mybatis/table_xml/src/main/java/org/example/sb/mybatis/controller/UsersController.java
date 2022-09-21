package org.example.sb.mybatis.controller;

import org.example.sb.mybatis.domain.Users;
import org.example.sb.mybatis.req.NameInReq;
import org.example.sb.mybatis.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/getAll")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/namein")
    public List<Users> namein(@RequestBody NameInReq nameInReq) {
        return usersService.namein(nameInReq.getNames(), nameInReq.getName());
    }
}
