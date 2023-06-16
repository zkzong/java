package org.example.sb.service;

import org.example.sb.dto.UserDTO;

public interface UserService {

    int save(UserDTO userDTO);

    int updateById(UserDTO userDTO);

}
