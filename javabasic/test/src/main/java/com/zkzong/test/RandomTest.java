package com.zkzong.test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by Zong on 2016/10/12.
 */
public class RandomTest {
    public static void main(String[] args) {
        Random r1 = new Random(47);
        System.out.println(r1.nextInt(20));
        Random r2 = new Random(47);
        System.out.println(r2.nextInt(20));

//        注意 Math.random() 这个方法返回是 double 类型，注意取值的范围 0≤x<1（ 能够
//        取到零值，注意除零异常） ，如果想获取整数类型的随机数，不要将 x 放大 10 的若干倍然后
//        取整，直接使用 Random 对象的 nextInt 或者 nextLong 方法。
        double d = Math.random();
        System.out.println("double = " + d);
        Random random = new Random();
        int i = random.nextInt();
        System.out.println("i = " + i);
        long l = random.nextLong();
        System.out.println("l = " + l);

        try {
            SecureRandom instanceStrong = SecureRandom.getInstanceStrong();
            int j = instanceStrong.nextInt(10);
            System.out.println(j);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
