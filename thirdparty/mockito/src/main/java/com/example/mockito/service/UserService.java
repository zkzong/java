package com.example.mockito.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mockito.entity.User;
import com.example.mockito.req.UserReq;

import java.util.List;

public interface UserService extends IService<User> {

    User selectById(Long id);

    List<User> query(String userName);

    List<User> query(UserReq req);

}
