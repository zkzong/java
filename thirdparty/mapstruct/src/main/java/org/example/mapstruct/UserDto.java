package org.example.mapstruct;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserDto implements Serializable {
    private Integer id;
    private String name;
    private String address;
    private Date birth;
}
