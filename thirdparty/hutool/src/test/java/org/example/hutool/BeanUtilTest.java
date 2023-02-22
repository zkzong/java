package org.example.hutool;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilTest {

    @Test
    public void more2Less() {
        More more = new More(1, "zong", 1);
        more.setSex("1");
        System.out.println(more);
        Less less = new Less();
        BeanUtils.copyProperties(less, more);
        System.out.println(less);
    }

}
