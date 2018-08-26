package com.codingbat.functional1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of integers, return a list where each integer is multiplied by 2.

 doubling([1, 2, 3]) → [2, 4, 6]
 doubling([6, 8, 6, 8, -1]) → [12, 16, 12, 16, -2]
 doubling([]) → []
 */
public class Doubling {
    public static void main(String[] args) {
        Integer [] numbers = {6, 8, 6, 8, -1};
        List<Integer> nums = Arrays.asList(numbers);

        List <Integer> doubledList = nums.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());

        //doubledList.stream()
         //       .forEach(System.out::println);
        List <Integer> expectedList = Arrays.asList(new Integer[] {12, 16, 12, 16, -2});
        
        assert(doubledList.equals(expectedList));
    }
}
