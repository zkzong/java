package org.example.collection.map;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zong on 2016/11/17.
 */
public class KeyIsObject {

    @Test
    public void keyObject() {
        Student s1 = new Student("zong", 30);
        Student s2 = new Student("zong", 30);
        Map m = new HashMap();
        // 不会覆盖
        m.put(s1, 1);
        m.put(s2, 2);

        m.remove(s2);
        System.out.println(JSON.toJSONString(m));
    }

}

class Student {
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
