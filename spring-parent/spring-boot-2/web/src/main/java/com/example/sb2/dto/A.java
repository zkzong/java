package com.example.sb2.dto;

import lombok.Data;

@Data
public class A<T> {
    private Integer age;
    private T t;
}
