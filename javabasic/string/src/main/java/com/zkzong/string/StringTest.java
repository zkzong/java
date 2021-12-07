package com.zkzong.string;

import org.junit.Test;

public class StringTest {

    @Test
    public void print() {
        String s = null;
        System.out.println(s);

        Integer i = null;
        System.out.println(i);

        String ss = null;
        ss = ss + "!";
        System.out.print(ss);
    }

    @Test
    public void contains() {
        String s = "a.b.c.d";
        boolean contains = s.contains(".b.");
        System.out.println(contains);
    }

    @Test
    public void matches1() {
        String s = "String a = service.getString()";
        boolean matches = s.matches("(.*)service(.*)");
        System.out.println(matches);
    }

    @Test
    public void matches2() {
        String Str = new String("www.runoob.com");

        System.out.print("返回值 :");
        System.out.println(Str.matches("(.*)runoob(.*)"));

        System.out.print("返回值 :");
        System.out.println(Str.matches("(.*)google(.*)"));

        System.out.print("返回值 :");
        System.out.println(Str.matches("www(.*)"));
    }

}
