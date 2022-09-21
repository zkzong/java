package org.example.serializable.single;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Person implements Serializable {

    private static class InstanceHolder {
        private static final Person instatnce = new Person("John", 31, Gender.MALE);
    }

    public static Person getInstance() {
        return InstanceHolder.instatnce;
    }

    private String name = null;

    private Integer age = null;

    private Gender gender = null;

    private Person() {
        System.out.println("none-arg constructor");
    }

    private Person(String name, Integer age, Gender gender) {
        System.out.println("arg constructor");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    /**
     * 无论是实现Serializable接口，或是Externalizable接口，当从I/O流中读取对象时，readResolve()方法都会被调用到。
     * 实际上就是用readResolve()中返回的对象直接替换在反序列化过程中创建的对象。
     * @return
     * @throws ObjectStreamException
     */
    private Object readResolve() throws ObjectStreamException {
        return InstanceHolder.instatnce;
    }

}
