package org.example.springredis.case2.domain;

/**
 * Created by Zong on 2017/3/4.
 */
public class User implements DomainObject {
    public static final String OBJECT_KEY = "USER";

    private String id;
    private String name;

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getKey() {
        return getId();
    }

    @Override
    public String getObjectKey() {
        return OBJECT_KEY;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
