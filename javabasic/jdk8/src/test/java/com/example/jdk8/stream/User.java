package com.example.jdk8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private int age;
    private BigDecimal salary;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
