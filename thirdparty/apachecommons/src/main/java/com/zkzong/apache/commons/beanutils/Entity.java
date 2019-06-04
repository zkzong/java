package com.zkzong.apache.commons.beanutils;

import lombok.Data;

/**
 * Created by Zong on 2017/2/6.
 */
@Data
public class Entity {
    private Integer id;
    private String name;

    public String haha() {
//        System.out.println("haha");
        return "haha";
    }

    public void sayHello(String s) {
        System.out.println("hello " + s);
//        return s;
    }

    public Object countAges(Integer i1, Integer i2) {
        int count = 0;
//        for (int i = 0; i < params.length; i++) {
//            Object param = params[i];
//            int parseInt = Integer.parseInt(param.toString());
//            count += parseInt;
//        }
        count = i1 + i2;
//        System.out.println("count = " + count);
        return "count = " + count;
    }

}
