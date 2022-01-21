package com.codingbat.functional1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class Square {
    public static List <Integer> square (List<Integer> nums) {
        List <Integer> squaredNums = nums.stream()
                .map(n -> n*n)
                .collect(Collectors.toList());
        return squaredNums;
    }

    public static void main(String [] args){
        Integer [] nums = {};
        List <Integer> squared = square(Arrays.asList(nums));
        squared.stream()
                .forEach(System.out::println);

    }
}
