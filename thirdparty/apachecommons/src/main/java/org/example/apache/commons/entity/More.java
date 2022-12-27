package org.example.apache.commons.entity;

import lombok.Data;

/**
 * Created by zong on 2017/2/24.
 */
@Data
public class More {

    private Integer id;
    private String name;
    private Integer age;
    private String sex;

    public More() {
    }

    public More(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

}
