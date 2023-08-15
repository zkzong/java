package com.example.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Zong on 2016/9/14.
 */
public class TransientTest2 {

    public static void main(String[] args) {
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
            // 在反序列化之前改变age的值
            User.age = 30;
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("user.txt"));
            user = (User) is.readObject();// 从流中读取User的数据
            is.close();

            System.out.println("\nread after Serializable: ");
            System.out.println("username: " + user.getUsername());
            System.out.println("password: " + user.getPasswd());
            System.out.println("age: " + user.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

/**
 * 反序列化后类中static型变量age的值为当前JVM中对应static变量的值，这个值是JVM中的不是反序列化得出的
 */
