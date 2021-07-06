package com.zkzong.mockito.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zkzong.mockito.entity.User;
import com.zkzong.mockito.req.UserReq;

import java.util.List;

public interface UserService extends IService<User> {

    User selectById(Long id);

    List<User> query(String userName);

    List<User> query(UserReq req);

}
