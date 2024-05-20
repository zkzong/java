package com.example.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zongz
 * @Date: 2024/5/20
 */
public class Main {

    /**
     * 1. 两数之和
     */
    class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[0];
        }
    }

    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; ++i) {
                if (hashtable.containsKey(target - nums[i])) {
                    return new int[]{hashtable.get(target - nums[i]), i};
                }
                hashtable.put(nums[i], i);
            }
            return new int[0];
        }
    }

    @Test
    public void twoSum() {
        int[] nums = {11, 15, 2, 7};
        int target = 9;
        Solution2 solution = new Solution2();
        int[] ints = solution.twoSum(nums, target);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}