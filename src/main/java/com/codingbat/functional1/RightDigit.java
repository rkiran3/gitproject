package com.codingbat.functional1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of non-negative integers, return an integer list of the rightmost digits. (Note: use %)

 rightDigit([1, 22, 93]) → [1, 2, 3]
 rightDigit([16, 8, 886, 8, 1]) → [6, 8, 6, 8, 1]
 rightDigit([10, 0]) → [0, 0]
 */
public class RightDigit {

    public static List <Integer> rightDigit(List<Integer> nums){
        List <Integer> output = nums.stream()
                .map(n -> n%10)
                .collect(Collectors.toList());

        return output;
    }

    public static void main(String [] args) {
        Integer [] numsArray = { 16, 8, 886, 8, 1 };
        List <Integer> numsList = Arrays.asList(numsArray);
        List <Integer> outputList = rightDigit(numsList);

        outputList.stream()
                .forEach(System.out::println);
    }
}
