package com.example.innerclass;

/**
 * Created by Zong on 2016/7/27.
 * 静态内部类
 */
public class StaticInnerClass {
    private String sex;
    public static String name = "zong";

    /**
     * 静态内部类
     */
    static class InnerClass1 {
        //在静态内部类中可以存在静态成员
        public static String _name1 = "zong_static";

        public void display() {
            //静态内部类只能访问外围类的静态成员变量和方法
            //不能访问外围类的非静态成员变量和方法
            System.out.println("OutClass name: " + name);
        }
    }

    /**
     * 非静态内部类
     */
    class InnerClass2 {
        //非静态内部类中不能存在静态成员
        public String _name2 = "zong_inner";

        //非静态内部类中可以调用外围类的任何成员,不管是静态的还是非静态的
        public void display() {
            System.out.println("OuterClass name: " + name);
        }
    }

    /**
     * 外围类方法
     */
    public void display() {
        //外围类访问静态内部类：内部类
        System.out.println(InnerClass1._name1);
        //静态内部类可以直接创建实例不需要依赖于外围类
        new InnerClass1().display();
        //非静态内部的创建需要依赖于外围类
        StaticInnerClass.InnerClass2 inner2 = new StaticInnerClass().new InnerClass2();
        //非静态内部类的成员需要使用非静态内部类的实例
        System.out.println(inner2._name2);
        inner2.display();
    }

    public static void main(String[] args) {
        StaticInnerClass outer = new StaticInnerClass();
        outer.display();

        new OuterClass1<String>().new InnerAbstractClass() {
            @Override
            public void absMethod() {
                System.out.println("absMethod...");
            }
        }.absMethod();

    }
}
