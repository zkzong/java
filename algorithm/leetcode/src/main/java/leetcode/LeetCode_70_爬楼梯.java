package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_70_爬楼梯 {

    /**
     * 递归
     *
     * @param n
     * @return
     */
    private int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }

    @Test
    public void testclimbStairs1() {
        int n = 5;
        int result = climbStairs1(n);
        System.out.println(result);
    }

    private Map<Integer, Integer> storeMap = new HashMap<>();

    /**
     * 递归，自顶向下
     *
     * @param n
     * @return
     */
    private int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (null != storeMap.get(n)) {
            return storeMap.get(n);
        } else {
            int result = climbStairs2(n - 1) + climbStairs2(n - 2);
            storeMap.put(n, result);
            return result;
        }
    }

    @Test
    public void testclimbStairs2() {
        int n = 5;
        int result = climbStairs2(n);
        System.out.println(result);
    }

    /**
     * 循环，自底向上
     *
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; i++) {
            result = pre + prepre;
            prepre = pre;
            pre = result;
        }
        return result;
    }

    @Test
    public void testclimbStairs3() {
        int n = 5;
        int result = climbStairs3(n);
        System.out.println(result);
    }

}
