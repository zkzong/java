package com.example.powermock.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.powermock.entity.User;
import com.example.powermock.req.UserReq;

import java.util.List;

public interface UserService extends IService<User> {

    List<User> query(String userName);

    List<User> query(UserReq req);

}
