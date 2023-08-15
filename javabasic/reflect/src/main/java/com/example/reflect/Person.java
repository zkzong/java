package com.example.reflect;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Zong on 2016/11/22.
 */
@Getter
@Setter
public class Person implements InterFace {
    private String id;
    private String name;
    public String age;

    public Person() {
    }

    public Person(String id) {
        this.id = id;
    }

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 静态方法
     */
    public static void update() {
    }

    private void test() {
    }

    @Override
    public void read() {

    }
}
