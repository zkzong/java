package com.zkzong.mockito;

import lombok.Data;

@Data
public class Person {
    private Integer id;
    private String name;
    private String key;

    public String setKeyById(int id) {
        this.key = id + this.name + id;
        return this.key;
    }
}
