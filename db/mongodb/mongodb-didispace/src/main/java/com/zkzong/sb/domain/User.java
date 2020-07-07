package com.zkzong.sb.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author zkzong
 * @date 2017/10/20
 */
public class User {
    @Id
    private Long id;
    private String username;
    private Integer age;
    private Date date;

    public User() {
    }

    public User(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public User(Long id, String username, Integer age, Date date) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
