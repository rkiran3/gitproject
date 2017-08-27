package com.codingbat.ap1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an array of positive ints, return a new array of length "count" containing the first even numbers from the original array. The original array will contain at least "count" even numbers.

 copyEvens([3, 2, 4, 5, 8], 2) → [2, 4]
 copyEvens([3, 2, 4, 5, 8], 3) → [2, 4, 8]
 copyEvens([6, 1, 2, 4, 5, 8], 3) → [6, 2, 4]
 */
public class CopyEvens {

    public static int [] copyEvens (int [] nums, int count) {
        int [] result = {};

        // Operate on int Array and convert List of Integers to Array of ints
        result = IntStream.of(nums)
                .filter(i -> (i % 2 ==0))
                .limit(count)
                .boxed()
                .mapToInt(i->i)
                .toArray();
        return result;
    }

    public static void main(String [] args) {
        System.out.println("Test1");
        int [] nums = {3, 2, 4, 5, 8};
        IntStream.of(copyEvens(nums, 2))
                .forEach(System.out::println);  // prints 2, 4

        System.out.println("Test2");
        nums = new int [] {3, 2, 4, 5, 8};
        IntStream.of(copyEvens(nums, 3))
                .forEach(System.out::println);  // prints 2, 4, 8

        System.out.println("Test3");
        nums = new int [] {6, 1, 2, 4, 5, 8};
        IntStream.of(copyEvens(nums, 3))
                .forEach(System.out::println);  // prints 6, 2, 4

    }
}
