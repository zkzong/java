package org.example.mp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zkzong
 * @Date: 2018.9.8
 */
@Data
public class TUser implements Serializable {
    private Long id;
    private String userName;
    private Integer age;
    private String email;
}
