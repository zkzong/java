package org.example.sb.redis.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class User implements Serializable {

    private Integer id;
    private String username;
    private Integer age;
    private Date birthday;
    private String sex;
    private String address;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

}
