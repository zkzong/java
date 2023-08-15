package com.example.collection.set;

/**
 * Created by Zong on 2017/5/4.
 */
public class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return (this.getName() + this.getAge()).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User u = (User) obj;
            if (this.getName().equals(u.getName()) && this.getAge().equals(u.getAge())) {
                return true;
            }
        }
        return false;
    }
}
