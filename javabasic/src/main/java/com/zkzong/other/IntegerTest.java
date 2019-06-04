package com.zkzong.other;

import org.junit.Test;

/**
 * Created by Zong on 2016/8/13.
 */
public class IntegerTest {

    @Test
    public void integerCompare() {
        // http://www.importnew.com/6997.html
        // int的值在-128到127这个范围内JVM会将值缓存起来，因此i1和i2，虚拟机确确实实使用了相同的对象实例（内存地址相同），所以“==”会返回true的结果。
        // 但是在这个范围之外就不行了
        Integer i1 = 260;
        Integer i2 = 260;
        if (i1 == i2) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }

        Integer i3 = 100;
        Integer i4 = 100;
        if (i3 == i4) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }
    }

    @Test
    public void shortTest() {
        short s = 1;

        // 对于“+=”操作，系统会自动执行类型转换操作，等价于s=(short)s+1。
        s += 1;

        // s+1的时候，结果会被“升格”为int类型。把int赋给short当然编译错误。
        //s = s + 1;
    }

    @Test
    public void test() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;
        System.out.println(c == d); // true
        System.out.println(e == f); // false
        System.out.println(c == (a + b)); // true
        System.out.println(c.equals(a + b)); // true
        System.out.println(g == (a + b)); // true
        System.out.println(g.equals(a + b)); // false
        System.out.println(g.equals(a + h)); // true

        // 第一个和第二个输出结果没有什么疑问。
        // 第三句由于a+b包含了算术运算，因此会触发自动拆箱过程（会调用intValue方法），因此它们比较的是数值是否相等。
        // 而对于c.equals(a+b)会先触发自动拆箱过程，再触发自动装箱过程，也就是说a+b，会先各自调用intValue方法，得到了加法运算后的数值之后，便调用Integer.valueOf方法，再进行equals比较。
        // 同理对于后面的也是这样，不过要注意倒数第二个和最后一个输出的结果（如果数值是int类型的，装箱过程调用的是Integer.valueOf；如果是long类型的，装箱调用的Long.valueOf方法）。
    }

    @Test
    public void tt() {
        int a = 10;
        long b = 10L;
        double c = 10.0;
        System.out.println(a == b); // true
        System.out.println(a == c); // true
        System.out.println(b == c); // true
    }

}
