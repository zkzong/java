package com.zkzong.json;

import lombok.Data;

/**
 * Created by Zong on 2016/8/6.
 */
@Data
public class User {
    //@JSONField(serialize = false)
    private Long id;
    private String name;
    private Integer age;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
