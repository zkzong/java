package com.example.mapstruct;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String name;
    private String address;
    private Date birth;
}
