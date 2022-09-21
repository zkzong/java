package org.example.string;

import org.junit.Test;

/**
 * Created by Zong on 2016/8/14.
 * http://www.importnew.com/21024.html
 */
public class StringIntern {

    @Test
    public void test1() {
        String str1 = "string";
        String str2 = new String("string");
        String str3 = str2.intern();

        System.out.println(str1 == str2); // false
        System.out.println(str1 == str3); // true

        // 因为str1指向的是字符串中的常量，str2是在堆中生成的对象，所以str1==str2返回false。
        // str2调用intern方法，会将str2中值（“string”）复制到常量池中，但是常量池中已经存在该字符串（即str1指向的字符串），所以直接返回该字符串的引用，
        // 但str2.intern()返回的是常量字符串，因此str1==str3返回true。
    }

    @Test
    public void test2() {
        String baseStr = "baseStr";
        final String baseFinalStr = "baseStr";

        String str1 = "baseStr01";
        String str2 = "baseStr" + "01";
        String str3 = baseStr + "01";
        String str4 = baseFinalStr + "01";
        String str5 = new String("baseStr01").intern();

        System.out.println(str1 == str2); // true
        System.out.println(str1 == str3); // false
        System.out.println(str1 == str4); // true
        System.out.println(str1 == str5); // true

        // str1==str2 肯定会返回true，因为str1和str2都指向常量池中的同一引用地址。所以其实在JAVA 1.6之后，常量字符串的“+”操作，编译阶段直接会合成为一个字符串。
        // 因为str3实际上是StringBuilder.append()生成的结果，所以与str1不相等，结果返回false。
        // 因为str1和str4指向的都是常量池中的第三项，所以str1==str4返回true。这里我们还能发现一个现象，对于final字段，编译期直接进行了常量替换，而对于非final字段则是在运行期进行赋值处理的。
        // 因为str5和str1都指向的都是常量池中的同一个字符串，所以str1==str5返回true。

    }

    @Test
    public void test3() {
        String str1 = new String("str") + new String("01");
        str1.intern();
        String str2 = "str01";
        String str3 = new String("str01");
        str3.intern();
        System.out.println(str1 == str2); // true
        System.out.println(str1 == str3); // false

        // 在第一种情况下，因为常量池中没有“str01”这个字符串，所以会在常量池中生成一个对堆中的“str01”的引用，
        // 而在进行字面量赋值的时候，常量池中已经存在，所以直接返回该引用即可，因此str1和str2都指向堆中的字符串，返回true。
    }

    @Test
    public void test4() {
        String str1 = "str01";
        String str2 = new String("str") + new String("01");
        str2.intern();
        String str3 = new String("str01");
        str3.intern();
        System.out.println(str1 == str2); // false
        System.out.println(str1 == str3); // false
        System.out.println(str1 == str2.intern()); // true
        System.out.println(str1 == str3.intern()); // true

        // 调换位置以后，因为在进行字面量赋值（String str1 = “str01″）的时候，常量池中不存在，所以str1指向的常量池中的位置，
        // 而str2指向的是堆中的对象，再进行intern方法时，对str1和str2已经没有影响了，所以返回false。
    }

    @Test
    public void test5() {
        String s = new String("abc");
        String s1 = "abc";
        String s2 = new String("abc");

        System.out.println(s == s1.intern()); // false
        System.out.println(s == s2.intern()); // false
        System.out.println(s1 == s2.intern()); // true
    }

    // 当常量池中有该字符串常量时，intern()方法没有任何作用
    // 当常量池中没有该字符串常量时，intern()方法创建常量，并指向常量
    // s.intern()赋值给的变量是常量字符串
    @Test
    public void mytest() {
        String s1 = new String("s");
        s1.intern();
        String s2 = "s";
        System.out.println(s1 == s2); // false
        // 创建是s1时，同时常量池中创建“s”，所以s1.intern()没有起作用，s1和s2比较就是对象和常量的比较，所以false

        String s3 = new String("s") + new String("s");
        s3.intern();
        String s4 = "ss";
        System.out.println(s3 == s4); // true
        // s3.intern()时，常量池中没有“ss”，此时在常量池中创建该常量，s3指向该常量，s4也指向该常量，所以true
    }

    // 常量池中默认有“java”
    @Test
    public void testJava() {
        String s1 = new String("java");
        s1.intern();
        String s2 = "java";
        System.out.println(s1 == s2); // false
        // s1.intern()相当于没有作用，常量和引用比较，所以为false

        String s3 = new String("ja") + new String("va");
        s3.intern();
        String s4 = "java";
        System.out.println(s3 == s4); // false
        // 同上

        String s5 = new String("ja") + new String("va1");
        s5.intern();
        String s6 = "java1";
        System.out.println(s5 == s6); // true
        // 常量池中没有java1，所以s5.intern()之后s5是常量，和s6相等
    }
}
