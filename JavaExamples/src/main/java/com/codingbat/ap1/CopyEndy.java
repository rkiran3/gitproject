package com.codingbat.ap1;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * We'll say that a positive int n is "endy" if it is in the range 0..10 or 90..100 (inclusive). Given an array of positive ints, return a new array of length "count" containing the first endy numbers from the original array. Decompose out a separate isEndy(int n) method to test if a number is endy. The original array will contain at least "count" endy numbers.

 copyEndy([9, 11, 90, 22, 6], 2) => [9, 90]
 copyEndy([9, 11, 90, 22, 6], 3) => [9, 90, 6]
 copyEndy([12, 1, 1, 13, 0, 20], 2) => [1, 1]
 */
public class CopyEndy {
    public static Predicate<Integer> isEndyPredicate = n -> (n >=0 && n <10) || (n>=90 && n<=100);
    public static IntPredicate isEndyIntPredicate = n -> (n >=0 && n <10) || (n>=90 && n<=100);
    
    public static boolean isEndy(int n) {
        //System.out.println("n = [" + n + "]");
        boolean result = (n >=0 && n <10) || (n>=90 && n<=100);
        return result;
    }

    public static int [] copyEndy(int [] nums, int count) {
        int [] result = null;
        result = IntStream.of(nums)
                .boxed()
                .filter(n -> isEndy(n))
                //.peek(System.out::println)
                .limit(count)
                .mapToInt(i -> i)
                .toArray();
    	
    	
    	// using Predicate<Integer>
        result = IntStream.of(nums)
                .boxed()
                .filter(isEndyPredicate)
                .limit(count)
                .mapToInt(i -> i)
                .toArray();

        // using IntPredicate
        result = IntStream.of(nums)
                .filter(isEndyIntPredicate)
                .limit(count)
                .toArray();

        return result;
    }
    public static void main(String [] args){
        System.out.println("Test1");
        int [] nums = {9, 11, 90, 22, 6};
        System.out.println(
                IntStream.of(copyEndy(nums, 2))
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining(", ", "[", "]")));// prints [9, 90]

        System.out.println("Test2");
        System.out.println(
                IntStream.of(copyEndy(nums, 3))
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining(", ", "[", "]")));  // prints [9, 90, 6]

        System.out.println("Test3");
        nums = new int [] {12, 1, 1, 13, 0, 20};
        System.out.println(
                IntStream.of(copyEndy(nums, 2))
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining(", ", "[", "]")));  // prints [1, 1]
    }
}
