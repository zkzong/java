package com.zkzong.override;

import org.junit.Test;

/**
 * Created by Zong on 2016/12/4.
 */
public class Static {
    public static void main(String[] args) {
        Father father = new Father();
        Father child = new Child();
        System.out.println(father.getName()); // Father
        System.out.println(child.getName()); // Father
        /*
        因为这两个getName方法是静态方法，所以在内存中的地址空间是固定的，根本不存在冲突的问题。
        也就是说，这两个方法在内存中占用了相同的空间，而具体执行哪一个，则要看是由哪个类来调用。
        因为是静态方法，而且两个引用都是father的，所以只会调用father的方法。
         */
    }

    @Test
    public void test() {
        System.out.println(new Father().getName()); // Father
        System.out.println(new Child().getName()); // Child
        System.out.println(Father.getName()); // Father
        System.out.println(Child.getName()); // Child
    }
}

class Father {
    public static String getName() {
        return "Father";
    }
}

class Child extends Father {
    public static String getName() {
        return "Child";
    }
}
