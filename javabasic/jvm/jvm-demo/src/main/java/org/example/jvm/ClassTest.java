package org.example.jvm;

import org.junit.Test;

import java.net.URL;

/**
 * Created by Zong on 2016/8/9.
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("org.example.jvm.ClassTest");
        System.out.println(clazz);

        URL systemResource = ClassLoader.getSystemResource("");
        System.out.println(systemResource);
    }


    /**
     * 得到一个实例对象对应的Class对象有以下三种方式
     */
    @Test
    public void getClassInstance() {
        // 1.通过实例变量的getClass()方法
        Dog dog = new Dog();
        Class c = dog.getClass();
        System.out.println(c);

        // 2.通过类Class的静态方法forName()
        try {
            Class dog1 = Class.forName("org.example.jvm.Dog");
            System.out.println(dog1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3.直接给出对象类文件的.class
        Class dog2 = Dog.class;
        System.out.println(dog2);

    }
}
