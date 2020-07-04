package com.zkzong.sb2.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: Zong
 * @Date: 2018/12/8
 */
@Entity
@Table(name = "t_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
}
