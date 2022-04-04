package com.zkzong.copy;

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

    @Test
    public void copy() {
        Person person1 = new Person(new Address("武汉"));
        Person person1Copy = person1.clone();
        // 浅拷贝：true
        // 深拷贝：false
        System.out.println(person1.getAddress() == person1Copy.getAddress());
    }

}

@Data
class User {
    private String name;
    private int age;
}
