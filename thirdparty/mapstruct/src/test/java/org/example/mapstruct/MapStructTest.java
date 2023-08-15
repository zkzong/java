package org.example.mapstruct;

import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.util.Date;

public class MapStructTest {

    @Test
    public void userPoToUserDto() {
        User user = new User();
        user.setId(1);
        user.setName("myx");
        user.setAddress("河北沧州");
        user.setBirth(new Date());
        UserMapper mapper = Mappers.getMapper(UserMapper.class);
        UserDto userDto = mapper.userToUserDto(user);
        System.out.println(userDto);
    }

}
