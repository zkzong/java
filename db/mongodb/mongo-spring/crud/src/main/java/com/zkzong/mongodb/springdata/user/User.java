package com.zkzong.mongodb.springdata.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @Indexed
    private String ic;
    private String name;
    private int age;
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Date createdDate;

    public User() {
    }

    public User(String ic, String name, int age) {
        this.ic = ic;
        this.name = name;
        this.age = age;
    }

    public User(String ic, String name, int age, Date createdDate) {
        this.ic = ic;
        this.name = name;
        this.age = age;
        this.createdDate = createdDate;
    }
}
