package com.codewars;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindOddPractice {

    public static void findIt(int[] a) {
        long key = IntStream.of(a)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .filter(e -> (e.getValue().intValue() % 2) == 1)
            .findAny()
            .get()
            .getKey();

        System.out.println(key);
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 2};

        FindOddPractice.findIt(nums);
    }
    
}
