package com.zkzong.exception;

/**
 * Created by Zong on 2016/7/14.
 */
public class TryCatch {
    public static void main(String[] args) {
        /**
         * 异常被catch之后，后面的代码会继续执行
         */
        int t = 10;
        try {
            throw new Exception();
        } catch (Exception e) {
            t = 11;
            e.printStackTrace();
//            throw new Exception();
        }
        System.out.println(t); // 11
        System.out.println("继续执行");
    }
}
