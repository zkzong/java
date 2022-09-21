package org.example.string;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 通过反射修改String的值
 *
 * @Author: zkzong
 * @Date: 2018.9.30
 */
public class StringMod {

    @Test
    public void mod() throws NoSuchFieldException, IllegalAccessException {
        String s = "abcd";
        System.out.println("s = " + s);

        Field valueField = String.class.getDeclaredField("value");
        valueField.setAccessible(true);

        char[] value = (char[]) valueField.get(s);
        value[3] = 'e';
        System.out.println("s = " + s);

        valueField.set(s, new char[]{'1', '2', '3'});
        Field countField = String.class.getDeclaredField("count");
        countField.setAccessible(true);
        countField.set(s, 3);
        System.out.println("s = " + s);

    }
}
