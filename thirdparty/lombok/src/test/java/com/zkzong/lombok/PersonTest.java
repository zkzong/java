package com.zkzong.lombok;

import org.junit.Test;

/**
 * Created by zong on 2017/3/27.
 */
public class PersonTest {

    @Test
    public void set() {
        Person p = new Person();
        p.setName("zong");
        p.setAge(30);
        p.setSex('男');
        p.setHeight(1.69);
        p.setAddress("henna");
        System.out.println(p);
        System.out.println(p.toString());
    }
}