package com.zkzong.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zong on 2016/11/28.
 */
public class InitialCapacity {
    public static void main(String[] args) {
        Student student = null;
        long begin1 = System.currentTimeMillis();
        List<Student> list1 = new ArrayList<Student>();
        for (int i = 0; i < 10000000; i++) {
            student = new Student(i, "zong", i);
            list1.add(student);
        }
        Long end1 = System.currentTimeMillis();
        System.out.println("list1 time：" + (end1 - begin1)); // 5912

        long begin2 = System.currentTimeMillis();
        List<Student> list2 = new ArrayList<Student>(10000000);
        for (int i = 0; i < 10000000; i++) {
            student = new Student(i, "zong", i);
            list2.add(student);
        }
        Long end2 = System.currentTimeMillis();
        System.out.println("list2 time：" + (end2 - begin2)); // 928
    }
}
