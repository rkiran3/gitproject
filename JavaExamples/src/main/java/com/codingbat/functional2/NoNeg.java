package com.codingbat.functional2;

import java.util.Arrays;
import java.util.LinkedList;
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

        List <Integer> output = nums.stream()
                .filter(n -> n>0)
                .collect(Collectors.toList());
        return  output;
    }

    public static void main(String[] args) {
        List <Integer> output = noNeg(Arrays.asList(1, -2));

        output.stream()
                .forEach(System.out::println);

        output = noNeg(Arrays.asList(-1, -1, -1));
        output.stream()
                .forEach(System.out::println);


    }
}
