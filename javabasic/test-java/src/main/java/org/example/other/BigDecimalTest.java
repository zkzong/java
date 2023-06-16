package org.example.other;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by Zong on 2016/8/29.
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        // 1. 使用BigDecimal(String val)的构造方法创建对象
        System.out.println(new BigDecimal("1.745"));
        System.out.println(new BigDecimal("0.745"));
        // 2. 使用使用BigDecimal的valueOf(double val)方法创建对象
        System.out.println(BigDecimal.valueOf(1.745));
        System.out.println(BigDecimal.valueOf(0.745));

        BigDecimal a = new BigDecimal(0.00);
        BigDecimal b = new BigDecimal("0.00");
        BigDecimal c = new BigDecimal("0.00");
        BigDecimal d = new BigDecimal("0.0");
        System.out.println(a.equals(c)); // false
        System.out.println(b.equals(c)); // true
        System.out.println(c.equals(d)); // false

        double doubleVal = 1.745;
        double doubleVal1 = 0.745;
        BigDecimal bdTest = new BigDecimal(doubleVal);
        BigDecimal bdTest1 = new BigDecimal(doubleVal1);
        System.out.println(bdTest);
        System.out.println(bdTest1);
        bdTest = bdTest.setScale(2, BigDecimal.ROUND_HALF_UP);
        bdTest1 = bdTest1.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("bdTest:" + bdTest); // 1.75
        System.out.println("bdTest1:" + bdTest1); // 0.74
        // 使用参数为float或double的BigDecimal创建对象会丢失精度。
        // 因此强烈建议不要使用参数为float或double的BigDecimal创建对象。
    }

    /**
     * 删除数字后面无用的0：stripTrailingZeros
     */
    @Test
    public void deleteZero() {
        BigDecimal bd = new BigDecimal("0.20");
        System.out.println(bd.stripTrailingZeros()); // 0.2
        bd = new BigDecimal("8.00");
        System.out.println(bd.stripTrailingZeros()); // 8
        // 大于等于10之后变成科学计数法
        bd = new BigDecimal("10.00");
        System.out.println(bd.stripTrailingZeros()); // 1E+1
        // 使用toPlainString解决科学计数法问题
        System.out.println(bd.stripTrailingZeros().toPlainString()); // 10
    }

    /**
     * 使用ROUND_HALF_UP进行四舍五入
     */
    @Test
    public void round() {
        BigDecimal bd1 = new BigDecimal("2.155");
        System.out.println(bd1.setScale(2, BigDecimal.ROUND_HALF_UP)); // 2.16

        BigDecimal bd2 = new BigDecimal(2.155);
        System.out.println(bd2.setScale(2, BigDecimal.ROUND_HALF_UP)); // 2.15

        System.out.println(new BigDecimal(1.555).setScale(2, BigDecimal.ROUND_HALF_UP)); // 1.55
        System.out.println(new BigDecimal(0.555).setScale(2, BigDecimal.ROUND_HALF_UP)); // 0.56
        System.out.println(new BigDecimal(1.556).setScale(2, BigDecimal.ROUND_HALF_UP)); // 1.56

        double doubleVal = 1.745;
        double doubleVal1 = 0.745;
        System.out.println(new BigDecimal(doubleVal)); // 1.74500000000000010658141036401502788066864013671875
        System.out.println(new BigDecimal(doubleVal1)); // 0.74499999999999999555910790149937383830547332763671875
        System.out.println(BigDecimal.valueOf(doubleVal)); // 1.745
        System.out.println(BigDecimal.valueOf(doubleVal1)); // 0.745

        System.out.println(new BigDecimal("0.00").subtract(new BigDecimal("0.00").setScale(2, BigDecimal.ROUND_HALF_UP)));
    }

    @Test
    public void compareTo() {
        BigDecimal bd = new BigDecimal("5");
        System.out.println(bd.compareTo(BigDecimal.ZERO)); // 大于 1
        System.out.println(bd.compareTo(new BigDecimal("10"))); // 小于 -1
        System.out.println(bd.compareTo(new BigDecimal("5"))); // 等于 0
    }

    @Test
    public void add() {
        BigDecimal bd = new BigDecimal(0);
        for (int i = 0; i < 10; i++) {
            bd = bd.add(new BigDecimal(10));
        }
        System.out.println(bd);
    }
}
