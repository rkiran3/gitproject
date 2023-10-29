package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String... args)     {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        int[] nums = { 3, 1, 4, 3};
        int target = 6;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i] )) {
                //map.get(target - i);
                System.out.println("found");
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        System.out.println(result);
    }
}
