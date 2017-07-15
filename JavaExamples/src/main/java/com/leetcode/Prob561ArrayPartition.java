package com.leetcode;

import java.util.Arrays;

/**
 * This is provided solution on LeetCode website.
 */
public class Prob561ArrayPartition {
    public static int arrayPairSum(int [] nums) {
        Arrays.sort(nums);
        int result = 0;

        for (int i=0; i < nums.length; i+=2) {
            result += nums[i];
        }

        return result;
    }

    public static void main(String [] args) {
        int [] nums = { 1, 3, 4, 2};

        System.out.println(arrayPairSum(nums));
    }
}
