package com.zkzong.sb.service;

import com.zkzong.sb.dto.UserDTO;

public interface UserService {

    int save(UserDTO userDTO);

    int updateById(UserDTO userDTO);

}
