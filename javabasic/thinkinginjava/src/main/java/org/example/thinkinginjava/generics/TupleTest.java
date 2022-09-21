package org.example.thinkinginjava.generics;

import org.example.thinkinginjava.util.FiveTuple;
import org.example.thinkinginjava.util.FourTuple;
import org.example.thinkinginjava.util.ThreeTuple;
import org.example.thinkinginjava.util.TwoTuple;

/**
 * Created by Zong on 2016/8/27.
 */
class Amphibian {
}

class Vehicle {
}

public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return new TwoTuple<String, Integer>("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<Amphibian, String, Integer>(
                new Amphibian(), "hi", 47
        );
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return new FourTuple<Vehicle, Amphibian, String, Integer>(
                new Vehicle(), new Amphibian(), "hi", 47
        );
    }

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return new FiveTuple<Vehicle, Amphibian, String, Integer, Double>(
                new Vehicle(), new Amphibian(), "hi", 47, 11.1
        );
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> ttsi = f();
//        ttsi.first = "there"; // Compile error: final
        System.out.println(ttsi);
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
