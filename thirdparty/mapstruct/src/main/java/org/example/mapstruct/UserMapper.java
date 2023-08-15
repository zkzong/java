package org.example.mapstruct;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    UserDto userToUserDto(User user);

    //集合
    List<UserDto> userToUserDto(List<User> users);
}
