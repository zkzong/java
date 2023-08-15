package com.example.reflect.example;

import com.example.reflect.example.pojo.Son;
import org.junit.Test;

import java.util.Map;

public class FieldAndMethodUtilTest {

    @Test
    public void Object2Map() {
        Son son = new Son();
        son.setName("test");
        son.setHeight(175.00);
        son.setWeight(60.55);
        Map<String, String> map = FieldAndMethodUtil.Object2Map(son);
        System.out.println(map);
    }

    @Test
    public void Object2MapByLoop() {
        Son son = new Son();
        son.setName("test");
        son.setHeight(175.00);
        son.setWeight(60.55);
        Map<String, String> map = FieldAndMethodUtil.Object2MapByLoop(son);
        System.out.println(map);
    }

    @Test
    public void Object2MapByRecursion() {
        Son son = new Son();
        son.setName("test");
        son.setHeight(175.00);
        son.setWeight(60.55);
        Map<String, String> map = FieldAndMethodUtil.Object2MapByRecursion(son);
        System.out.println(map);
    }

}