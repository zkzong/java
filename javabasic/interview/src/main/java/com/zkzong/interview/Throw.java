package com.zkzong.interview;

/**
 * Created by Zong on 2016/12/13.
 */
public class Throw {
    public static void main(String[] args) {
        try {
            System.out.println("Only try, no have catch");
            throw_do();
            System.out.println("After throw_do then print");
        } finally {
            System.out.println("finally exit");
        }
    }

    private static void throw_do() {
        throw new ArithmeticException();
    }
}
/*
先打印Only try, no have catch，
然后打印finally exit，
组后打印ArithmeticException异常信息
 */
