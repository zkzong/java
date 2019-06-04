package com.zkzong.collection;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zong on 17-4-15.
 */
public class Compare {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add(new Student("ttt", 66));
        list.add(new Student("bbb", 77));
        list.add(new Student("ccc", 99));
        list.add(new Student("fff", 88));
        list.add(new Student("aaa", 66));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}

class Student implements Comparable {
    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        Student n = (Student) o;
        int a = score.compareTo(n.score);
        return (a != 0 ? a : name.compareTo(n.name));
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
