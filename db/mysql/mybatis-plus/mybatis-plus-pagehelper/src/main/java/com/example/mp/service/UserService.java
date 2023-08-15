package com.example.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.example.mp.dto.UserDto;
import com.example.mp.entity.User;

public interface UserService extends IService<User> {

    PageInfo<User> query(UserDto dto);

}
