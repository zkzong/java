package org.example.call;

/**
 * @Author: zong
 * @Date: 2022/1/9
 */
public class CallByValue1 {

    private static int x = 10;

    public static void updateValue(int value) {
        value = 3 * value;
    }

    public static void main(String[] args) {
        System.out.println("调用前x的值：" + x);
        updateValue(x);
        System.out.println("调用后x的值：" + x);
    }

    //调用前x的值：10
    //调用后x的值：10

}
