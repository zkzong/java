package com.zkzong;

import lombok.Data;
import org.junit.Test;

public class Copy {

    /**
     * 使用=对对象赋值，是两个对象
     */
    @Test
    public void test() {
        User u1 = new User();
        u1.setName("zong");
        u1.setAge(30);
        System.out.println("u1=" + u1);

        User u2;
        u2 = u1;
        u2.setName("ma");
        System.out.println("u1=" + u1);
        System.out.println("u2=" + u2);
    }

}

@Data
class User {
    private String name;
    private int age;
}
