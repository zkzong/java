package org.example.powermock.controller;

import org.example.powermock.entity.User;
import org.example.powermock.req.UserReq;
import org.example.powermock.resp.UserResp;
import org.example.powermock.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
