package com.example.sb.redis.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Zong on 2017/5/10.
 */
@Data
public class Person implements Serializable {

    private String username;
    private Integer age;

    public Person(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

}
