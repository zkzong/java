package org.example.thinkinginjava.typeinfo;

import java.util.Random;

/**
 * Created by Zong on 2016/9/19.
 */
class Initable {
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        // Does not trigger initialization:
        System.out.println(Initable.staticFinal);
        // Does trigger initialization:
        System.out.println(Initable.staticFinal2);
        // Does trigger initialization:
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("org.example.thinkinginjava.typeinfo.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}

/**
 * 仅适用.class语法来获得对类的引用不会引发初始化
 * Class.forName()会立即进行初始化
 * <p>
 * static final值是“编译期常量”，就像Initable.staticFinal那样，这个值不需要对Initable类进行初始化就可以被读取
 * 但是，如果只是将一个域设置为static和final的，还不足以确保这种行为，例如，对Initable.staticFinal2的访问将强制进行类的初始化，因为它不是一个编译期常量
 * <p>
 * 如果一个static域不是final的，那么在对它访问时，总是要求在它被读取之前，要先进行链接（为这个域分配存储空间）和初始化（初始化该存储空间）：Initable2.staticNonFinal
 */
