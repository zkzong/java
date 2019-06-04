package com.zkzong.other;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by Zong on 2016/8/29.
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bg = new BigDecimal("0.00");

        BigDecimal a = new BigDecimal(0.00);
        BigDecimal c = new BigDecimal("0.00");
        System.out.println(c.equals(a)); // false
    }

    /**
     * 删除数字后面无用的0：stripTrailingZeros
     */
    @Test
    public void deleteZero() {
        BigDecimal bd = new BigDecimal("0.20");
        System.out.println(bd.stripTrailingZeros()); // 0.2
        bd = new BigDecimal("1.00");
        System.out.println(bd.stripTrailingZeros()); // 1
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
}
