package org.example.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultisetTest {
    public static void main(String[] args) {
        Multiset<String> multiset = HashMultiset.create();

        multiset.add("a");
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("b");

        System.out.println(multiset.size()); // 5
        System.out.println(multiset.count("a")); // 2
    }
}
