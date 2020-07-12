package com.zkzong;

import lombok.Data;

@Data
public class Student {
    private String firstName;
    private String lastName;
    private int rollNo;
    private String className;
    private Address address;
}
