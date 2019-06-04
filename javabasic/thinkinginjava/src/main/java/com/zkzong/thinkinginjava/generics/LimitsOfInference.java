package com.zkzong.thinkinginjava.generics;

import com.zkzong.thinkinginjava.typeinfo.pets.Person;
import com.zkzong.thinkinginjava.typeinfo.pets.Pet;
import com.zkzong.thinkinginjava.util.New;

import java.util.List;
import java.util.Map;

/**
 * Created by Zong on 2016/8/28.
 */
public class LimitsOfInference {
    static void f(Map<Person, List<? extends Pet>> petPeople) {
    }

    public static void main(String[] args) {
        f(New.map());
    }
}
