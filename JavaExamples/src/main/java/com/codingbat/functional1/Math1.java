package com.codingbat.functional1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of integers, return a list where each integer is added to 1 and the result is multiplied by 10.

 math1([1, 2, 3]) → [20, 30, 40]
 math1([6, 8, 6, 8, 1]) → [70, 90, 70, 90, 20]
 math1([10]) → [110]
 */
public class Math1 {
    public static List <Integer> math1(List<Integer> nums) {
        List<Integer> output = nums.stream()
                .map(n -> (n+1)*10)
                .collect(Collectors.toList());
        return output;
    }

    public static void main(String [] args) {
        Integer [] numsArray = {10};
        List <Integer> numsList = Arrays.asList(numsArray);

        List <Integer> output = math1(numsList);

        output.stream()
                .forEach(System.out::println);
    }
}
