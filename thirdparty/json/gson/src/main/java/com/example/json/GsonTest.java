package com.example.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Created by zong on 16-8-6.
 */
public class GsonTest {
    public static void main(String[] args) {
        //Primitives Examples
        // Serialization
        Gson gson = new Gson();
        gson.toJson(1);            // ==> 1
        gson.toJson("abcd");       // ==> "abcd"
        gson.toJson(Long.valueOf(10)); // ==> 10
        int[] values = {1};
        gson.toJson(values);       // ==> [1]

        // Deserialization
        int one = gson.fromJson("1", int.class);
        Integer oneI = gson.fromJson("1", Integer.class);
        Long oneL = gson.fromJson("1", Long.class);
        Boolean f = gson.fromJson("false", Boolean.class);
        String str = gson.fromJson("\"abc\"", String.class);
        String[] anotherStr = gson.fromJson("[\"abc\"]", String[].class);


        //Array Examples
        int[] ints = {1, 2, 3, 4, 5};
        String[] strings = {"abc", "def", "ghi"};

        // Serialization
        gson.toJson(ints);     // ==> [1,2,3,4,5]
        gson.toJson(strings);  // ==> ["abc", "def", "ghi"]

        // Deserialization
        int[] ints2 = gson.fromJson("[1,2,3,4,5]", int[].class);
        // ==> ints2 will be same as ints


        //Collections Examples
//        Collection<Integer> intsColl = Lists.immutableList(1,2,3,4,5);

        // Serialization
        String json = gson.toJson(ints);  // ==> json is [1,2,3,4,5]

        // Deserialization
        Type collectionType = new TypeToken<Collection<Integer>>() {
        }.getType();
        Collection<Integer> intsColl2 = gson.fromJson(json, collectionType);
        // ==> ints2 is same as ints

        //直接输出到控制台
        gson.toJson("1", System.out);

    }
}
