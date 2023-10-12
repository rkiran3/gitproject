package com.codingbat.functional2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of non-negative integers, return a list of those numbers except omitting any that end with 9. (Note: % by 10)

 no9([1, 2, 19]) → [1, 2]
 no9([9, 19, 29, 3]) → [3]
 no9([1, 2, 3]) → [1, 2, 3]

 */
public class No9 {
    public static List<Integer> no9(List <Integer> nums) {
        List <Integer> output = nums.stream()
                .filter(n -> (n%10 != 9))
                //.peek(System.out::println)
                .collect(Collectors.toList());
        return output;
    }
    public static void main(String [] args) {
        List <Integer> output = no9(Arrays.asList(1, 2, 19));

        output.stream()
                .forEach(System.out::println);
    }
}
