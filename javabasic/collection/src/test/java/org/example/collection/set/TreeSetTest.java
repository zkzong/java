package com.example.collection.set;

import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Zong on 2016/11/14.
 */
public class TreeSetTest {
    @Test
    public void sort() {
        Set<Integer> set = new TreeSet<Integer>(new ComparatorImpl());
        set.add(3);
        set.add(5);
        set.add(4);
        set.add(2);

        System.out.println(set);
    }
}

class ComparatorImpl implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o2 > o1) {
            return 1;
        } else if (o2 < o1) {
            return -1;
        }
        return 0;
    }

}
