package com.zkzong.other;

/**
 * Created by Zong on 2016/11/17.
 */
class Super {
    static {
        System.out.println("static Super");
    }

    {
        System.out.println("not static Super");
    }

    public Super() {
        System.out.println("Super Constructor");
    }
}

public class Sub extends Super {
    static {
        System.out.println("static Sub");
    }

    {
        System.out.println("not static Sub");
    }

    public Sub() {
        System.out.println("Sub Constructor");
    }

    public static void main(String[] args) {
        new Sub();
        /**
         * 输出结果：
         * static Super
         * static Sub
         * not static Super
         * Super Constructor
         * not static Sub
         * Sub Constructor
         */
        // 父类静态代码块 子类静态代码块 父类非静态代码块 父类构造方法 子类非静态代码块 子类构造方法
    }
}
