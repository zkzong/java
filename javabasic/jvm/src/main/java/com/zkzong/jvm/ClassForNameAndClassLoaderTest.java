package com.zkzong.jvm;

/**
 * Created by Zong on 2016/12/12.
 */
class Point {
    static {
        System.out.println("loading Point");
    }

    int x, y;
}

class Line {
    static {
        System.out.println("loading Line");
    }
}

public class ClassForNameAndClassLoaderTest {
    public static void main(String[] args) {
        // 调用某个对象的getClass()方法
        Point p = new Point();
        Class a = p.getClass();
        System.out.println("a " + a.getName());

        // 调用某个类的class属性来获取该类对应的Class对象
        Class b = Point.class;
        System.out.println("b " + b.getName());
        System.out.println("--------------");

        // 全路径
        String wholeNamePoint = "com.zkzong.jvm.Point";
        // 使用Class类的forName()静态方法--类的全路径
        try {
            Class c1 = Class.forName(wholeNamePoint);
            System.out.println("c1 " + c1.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("--------------");

        // 测试使用ClassLoader的反射方式来获得该类对应的Class对象
        String wholeNameLine = "com.zkzong.jvm.Line";
        Class<?> demo = null;
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            demo = loader.loadClass(wholeNameLine);
            System.out.println("demo " + demo.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("--------------");

        try {
            // 因为上面可能会异常，demo可能会是null，所以直接demo.newInstance()可能会空指针异常
            // 测试什么时候执行类中的静态代码
            Line line = (Line) (demo != null ? demo.newInstance() : null);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
