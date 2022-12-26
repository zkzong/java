package org.example.guava;

import com.google.common.base.Optional;
import org.junit.Test;

/**
 * Created by zong on 2016/8/10.
 */
public class OptionalTest {
    public static void main(String[] args) {
        OptionalTest optionalTest = new OptionalTest();

        Integer value1 = null;
        Integer value2 = Integer.valueOf(10);

        // Optional.fromNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.fromNullable(value1);
        System.out.println(a);

        // Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);
        System.out.println(b);

        System.out.println(optionalTest.sum(a, b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        // Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        // Optional.or - returns the value if present otherwise returns
        // the default value passed.
        Integer value1 = a.or(Integer.valueOf(0));

        // Optional.get - gets the value, value should be present
        Integer value2 = b.get();

        return value1 + value2;
    }

    @Test
    public void main() {
        //Integer a = null;
        //Integer b = new Integer(10);
        //System.out.println(plus(a, b));

        Integer invalidInput = null;
        Optional<Integer> a = Optional.of(invalidInput);
        Optional<Integer> b = Optional.of(Integer.valueOf(10));
        System.out.println(plus(a, b));
    }

    public Integer plus(Integer a, Integer b) {
        return a + b;
    }

    public Integer plus(Optional<Integer> a, Optional<Integer> b) {
        return a.get() + b.get();
    }
}
