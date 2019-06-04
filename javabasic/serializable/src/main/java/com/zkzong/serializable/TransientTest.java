package com.zkzong.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Zong on 2016/9/14.
 * 使用transient关键字不序列化某个变量
 */
public class TransientTest {

    public static void main(String[] args) throws ClassNotFoundException {
        User user = new User();
        user.setUsername("zong");
        user.setPasswd("123456");
        user.setAge(20);

        System.out.println("read before Serializable: ");
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPasswd());
        System.out.println("age: " + user.getAge());

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("user.txt"));
            os.writeObject(user);// 将User对象写进文件
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("user.txt"));
            user = (User) is.readObject();// 从流中读取User的数据
            is.close();

            System.out.println("\nread after Serializable: ");
            System.out.println("username: " + user.getUsername());
            System.out.println("password: " + user.getPasswd());
            System.out.println("age: " + user.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

/**
 * 输出：
 * read before Serializable:
 * username: zong
 * password: 123456
 * age: 20
 *
 * read after Serializable:
 * username: zong
 * password: null
 * age: 20
 */

/**
 * 知识点：
 * 1）一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
 * 2）transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。变量如果是用户自定义类变量，则该类需要实现Serializable接口。
 * 3）被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
 *
 * 反序列化后类中static型变量age的值为当前JVM中对应static变量的值，这个值是JVM中的不是反序列化得出的
 */



