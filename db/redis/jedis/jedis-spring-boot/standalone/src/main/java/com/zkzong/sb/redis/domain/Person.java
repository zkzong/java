package com.zkzong.sb.redis.domain;

import java.io.Serializable;

/**
 * Created by Zong on 2017/5/10.
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 8783188637150356862L;

    private String username;
    private Integer age;

    public Person(String username, Integer age) {
        this.username = username;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
