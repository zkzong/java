package com.zkzong.mongodb.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@ToString
public class Person {
    private String id;
    private String userName;
    private int age;
}
