package com.example.mockito.controller;

import com.example.mockito.entity.User;
import com.example.mockito.req.UserReq;
import com.example.mockito.resp.UserResp;
import com.example.mockito.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zong
 * @Date: 2021/7/5
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/select")
    public UserResp<User> select(@RequestParam Long id) {
        UserResp<User> resp = new UserResp<>();
        resp.setCode("0000");
        resp.setMsg("SUCCESS");

        User user = userService.selectById(id);
        resp.setData(user);

        return resp;
    }

    @PostMapping("/insert")
    public UserResp insert(@RequestBody UserReq userReq) {
        UserResp resp = new UserResp();
        resp.setCode("0000");
        resp.setMsg("SUCCESS");

        User user = new User();
        BeanUtils.copyProperties(userReq, user);
        boolean save = userService.save(user);

        return resp;
    }

    @GetMapping("/get")
    public UserResp<List<User>> getUser(@RequestParam String userName) {
        UserResp<List<User>> resp = new UserResp<>();
        resp.setCode("0000");
        resp.setMsg("SUCCESS");

        List<User> userList = userService.query(userName);
        resp.setData(userList);

        return resp;
    }

    @PostMapping("query")
    public UserResp<List<User>> queryUser(@RequestBody UserReq userReq) {
        UserResp<List<User>> resp = new UserResp<>();
        resp.setCode("0000");
        resp.setMsg("SUCCESS");

        List<User> userList = userService.query(userReq);
        resp.setData(userList);

        return resp;
    }

}
