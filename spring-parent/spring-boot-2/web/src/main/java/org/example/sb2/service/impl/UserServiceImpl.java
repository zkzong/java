package com.example.sb2.service.impl;

import com.example.sb2.entity.User;
import com.example.sb2.repository.UserRepository;
import com.example.sb2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Zong
 * @Date: 2018/12/8
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public User save(User user) {
        User u = userRepository.save(user);
        return u;
    }
}
