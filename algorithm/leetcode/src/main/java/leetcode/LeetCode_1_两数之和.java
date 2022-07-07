package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_两数之和 {
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    @Test
    public void testtwoSum1() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum1(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                result[0] = i;
                result[1] = map.get(complement);
                return result;
            }
        }
        return result;
    }

    @Test
    public void testtwoSum2() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum2(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    public int[] twoSum3(int[] nums, int target) {
        // key为元素值，value为每个元素对应的下标
        Map<Integer, Integer> storeNums = new HashMap<>(nums.length, 1);
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            Integer anotherIndex = storeNums.get(another);
            if (null != anotherIndex) {
                result[0] = anotherIndex;
                result[1] = i;
                break;
            } else {
                storeNums.put(nums[i], i);
            }
        }
        return result;
    }

    @Test
    public void testtwoSum3() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum3(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
