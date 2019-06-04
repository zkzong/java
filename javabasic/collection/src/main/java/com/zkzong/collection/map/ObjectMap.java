package com.zkzong.collection.map;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: zkzong
 * @Date: 2018.10.9
 */
public class ObjectMap implements Serializable {
    private String name;
    private int age;
    private Map<String, String> map;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
