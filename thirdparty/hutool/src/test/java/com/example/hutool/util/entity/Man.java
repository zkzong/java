package com.example.hutool.util.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Man extends Person {

    private int sex;

}
