package org.example.clickhouse.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo implements Serializable {
    private int id;
    private String userName;
    private String passWord;
    private String phone;
    private String email;
    private String createDay;
}
