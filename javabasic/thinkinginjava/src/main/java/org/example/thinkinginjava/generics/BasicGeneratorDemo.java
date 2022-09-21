package org.example.thinkinginjava.generics;

import org.example.thinkinginjava.util.BasicGenerator;
import org.example.thinkinginjava.util.Generator;

/**
 * Created by Zong on 2016/8/30.
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
    }
}
