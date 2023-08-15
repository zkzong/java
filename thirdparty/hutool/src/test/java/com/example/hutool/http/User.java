package com.example.hutool.http;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private int id;
    private String name;
    private int age;
    private char sex;

}
