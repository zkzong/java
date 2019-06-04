package com.zkzong.string;

/**
 * Created by Zong on 2016/6/30.
 */
public class StringSplit {
    public static void main(String[] args) {
        String str = " abc  def g ";
        String[] ss = str.split(" ");
        System.out.println(ss.length);
        for (int i = 0; i < ss.length; i++) {
            String s = ss[i];
            System.out.println(s);
        }
        System.out.println("结束");

        String ipStr = "192.168.120.18";
        String[] ipArr = ipStr.split("\\.");
        for (int i = 0; i < ipArr.length; i++) {
            String s = ipArr[i];
            System.out.println(s);
        }
    }
}
