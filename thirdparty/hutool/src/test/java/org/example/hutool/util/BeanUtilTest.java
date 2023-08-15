package com.example.hutool.util;

import cn.hutool.core.bean.BeanUtil;
import org.junit.Test;

public class BeanUtilTest {

    @Test
    public void isEmpty() {
        // 字段没有原生类型时，会返回true
        Person person = new Person();
        // true
        System.out.println(BeanUtil.isEmpty(person));

        // 字段有原生类型时，会返回false
        Man man = new Man();
        // false
        System.out.println(BeanUtil.isEmpty(man));
    }
}
