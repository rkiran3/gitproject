package com.codingbat.functional2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of integers, return a list of the integers, omitting any that are less than 0.

 noNeg([1, -2]) → [1]
 noNeg([-3, -3, 3, 3]) → [3, 3]
 noNeg([-1, -1, -1]) → []
 */
public class NoNeg {
    public static List<Integer> noNeg(List <Integer> nums) {
        return nums.stream()
                .filter(n -> n>0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List <Integer> output = noNeg(Arrays.asList(1, -2));
        // output list does not contain any negative entries
        assert(output.equals(Arrays.asList(new Integer[] {1})));

        output = noNeg(Arrays.asList(-1, -1, -1));
        // output does not contain any positive entries
        assert(output.equals(Arrays.asList(new Integer[] {})));

    }
}
