package org.example.thinkinginjava.generics;

import org.example.thinkinginjava.typeinfo.pets.Person;
import org.example.thinkinginjava.typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2016/8/28.
 */
public class LimitsOfInference {
    static void f(Map<Person, List<? extends Pet>> petPeople) {
    }

    public static void main(String[] args) {
        // todo 报错
        //f(New.map());
    }
}
