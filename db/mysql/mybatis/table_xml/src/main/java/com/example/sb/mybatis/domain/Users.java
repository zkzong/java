package com.example.sb.mybatis.domain;

import lombok.Data;
import lombok.ToString;

/**
 * Created by Zong on 2017/6/1.
 */
@Data
@ToString
public class Users {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;
    private String userName;
    private Integer age;

}
