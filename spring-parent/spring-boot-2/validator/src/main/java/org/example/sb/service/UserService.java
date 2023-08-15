package com.example.sb.service;

import com.example.sb.dto.UserDTO;

public interface UserService {

    int save(UserDTO userDTO);

    int updateById(UserDTO userDTO);

}
