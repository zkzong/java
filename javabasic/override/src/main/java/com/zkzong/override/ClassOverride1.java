package com.zkzong.override;

/**
 * Created by Zong on 2016/12/4.
 */
class ClassA {
    public void printValue() {
        System.out.println("ClassA");
    }
}

class ClassB extends ClassA {
    @Override
    public void printValue() {
        System.out.println("ClassB");
    }
}

public class ClassOverride1 {
    public static void main(String[] args) {
        ClassB b = new ClassB();
        b.printValue(); // ClassB
        ClassA a = (ClassA) b; // 强制转换后仍是ClassB
        a.printValue(); // ClassB
        a = new ClassA();
        a.printValue(); // ClassA
    }
}
