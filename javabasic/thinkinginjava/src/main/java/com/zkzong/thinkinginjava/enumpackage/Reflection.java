package com.zkzong.thinkinginjava.enumpackage;

import com.zkzong.thinkinginjava.util.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import static com.zkzong.thinkinginjava.util.Print.print;
import static com.zkzong.thinkinginjava.util.Print.printnb;

/**
 * Created by zong on 2016/8/25.
 */
enum Explore {
    HERE, THERE
}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        print("----- Analyzing " + enumClass + " -----");
        print("Interfaces:");
        for (Type t : enumClass.getGenericInterfaces()) {
            print(t);
        }

        print("Base: " + enumClass.getSuperclass());

        print("Methods: ");
        Set<String> methods = new TreeSet<String>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        print(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        print("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        printnb("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        print(exploreMethods);
        OSExecute.command("javap Explore");
    }
}
