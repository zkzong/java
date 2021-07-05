package com.zkzong.powermock.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zkzong.powermock.entity.User;
import com.zkzong.powermock.req.UserReq;

import java.util.List;

public interface UserService extends IService<User> {

    List<User> query(String userName);

    List<User> query(UserReq req);

}
