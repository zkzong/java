package org.example.mockito.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.mockito.entity.User;
import org.example.mockito.req.UserReq;

import java.util.List;

public interface UserService extends IService<User> {

    User selectById(Long id);

    List<User> query(String userName);

    List<User> query(UserReq req);

}
