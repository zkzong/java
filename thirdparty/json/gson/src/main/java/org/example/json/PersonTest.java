package org.example.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zong on 2016/8/6.
 */
public class PersonTest {
    public static void main(String[] args) {
        Gson gson = new Gson();

        int[] ints = {1, 2, 3, 4, 5};
        String[] strings = {"abc", "def", "ghi"};

        // Serialization 序列化
        gson.toJson(ints);     // ==> [1,2,3,4,5]
        gson.toJson(strings);  // ==> ["abc", "def", "ghi"]

        // Deserialization 反序列化
        int[] ints2 = gson.fromJson("[1,2,3,4,5]", int[].class);
        // ==> ints2 will be same as ints

        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setName("name" + i);
            person.setAge(i * 5);
            persons.add(person);
        }
        //将对象转换成Json字符串
        String str = gson.toJson(persons);
        System.out.println(str);

        //从Json相关对象到java实体
        String s = "{\"name\":\"name0\",\"age\":0}";
        Person person = gson.fromJson(s, Person.class);
        System.out.println(person);

        //转换成列表类型
        List<Person> ps = gson.fromJson(str, new TypeToken<List<Person>>() {
        }.getType());
        for (int i = 0; i < ps.size(); i++) {
            Person p = ps.get(i);
            System.out.println(p);
        }

        //json数组转换成对象
        String strJsonArr = "[\"abc\",\"def\",\"ggg\"]";
        List<String> strList = gson.fromJson(strJsonArr, new TypeToken<List<String>>() {
        }.getType());
        for (int i = 0; i < strList.size(); i++) {
            String s1 = strList.get(i);
            System.out.println(s1);
        }

    }
}
