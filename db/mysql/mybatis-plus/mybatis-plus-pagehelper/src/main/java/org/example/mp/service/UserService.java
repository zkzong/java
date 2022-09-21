package org.example.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import org.example.mp.dto.UserDto;
import org.example.mp.entity.User;

public interface UserService extends IService<User> {

    PageInfo<User> query(UserDto dto);

}
