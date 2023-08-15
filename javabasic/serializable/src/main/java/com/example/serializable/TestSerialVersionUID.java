package com.example.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialVersionUID {
    public static void main(String[] args) throws Exception {
        SerializeCustomer();// 序列化Customer对象
        Customer customer = DeserializeCustomer();// 反序列Customer对象
        System.out.println(customer);
    }

    private static void SerializeCustomer() throws FileNotFoundException, IOException {
        Customer customer = new Customer("zong", 25);
        // ObjectOutputStream 对象输出流
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("Customer.txt")));
        oo.writeObject(customer);
        System.out.println("Customer对象序列化成功！");
        oo.close();
    }

    private static Customer DeserializeCustomer() throws Exception, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("Customer.txt")));
        Customer customer = (Customer) ois.readObject();
        System.out.println("Customer对象反序列化成功！");
        return customer;
    }

}

class Customer implements Serializable {
    // Customer类中没有定义serialVersionUID
    private String name;
    private int age;
    // 新添加的sex属性
    private String sex;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Customer(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "name=" + name + ", age=" + age;
    }
}
