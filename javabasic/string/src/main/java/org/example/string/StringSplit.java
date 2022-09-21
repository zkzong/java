package org.example.string;

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

        // 多个分隔符
        String s = "a,b,c|d|e";
        String[] regArr = s.split(",|\\|");
        for (String s1 : regArr) {
            System.out.println(s1);
        }
        String replaceAll = s.replaceAll(",|\\|", ";");
        System.out.println(replaceAll);
    }
}
