package com.zkzong.sb.service.impl;

import com.zkzong.sb.dto.UserDTO;
import com.zkzong.sb.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public int save(UserDTO userDTO) {
        return 1;
    }

    @Override
    public int updateById(UserDTO userDTO) {
        return 1;
    }

}
