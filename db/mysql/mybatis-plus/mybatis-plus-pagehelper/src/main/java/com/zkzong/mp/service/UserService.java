package com.zkzong.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.zkzong.mp.dto.UserDto;
import com.zkzong.mp.entity.User;

public interface UserService extends IService<User> {

    PageInfo<User> query(UserDto dto);

}
