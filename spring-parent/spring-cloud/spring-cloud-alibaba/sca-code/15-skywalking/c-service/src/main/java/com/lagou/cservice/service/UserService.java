package com.lagou.cservice.service;

import com.lagou.cservice.entiey.User;
import com.lagou.cservice.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;
    public List<User> selectAllUser(){
        return userRepository.selectAll();
    }

}
