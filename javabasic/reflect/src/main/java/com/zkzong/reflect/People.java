package com.zkzong.reflect;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by Zong on 2016/11/23.
 */
@Getter
@Setter
public class People {
    private Integer id;
    private String name;
    private BigDecimal amount;
    private int age;
    private boolean sex;

    // 构造函数1
    public People() {
        System.out.println("构造函数 无参");
    }

    // 构造函数2
    public People(Integer id) {
        this.id = id;
        System.out.println("构造函数 id：" + id);
    }

    // 构造函数3
    public People(Integer id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("构造函数 id：" + id + " name：" + name);
    }

}
