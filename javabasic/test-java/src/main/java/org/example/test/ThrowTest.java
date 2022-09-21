package org.example.test;

/**
 * Created by zong on 2017/2/28.
 */
public class ThrowTest {
    public static void main(String[] args) throws Exception {
        System.out.println(a());
    }

    private static String a() throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return "a";
        }
    }
}
