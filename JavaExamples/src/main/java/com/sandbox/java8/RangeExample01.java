package com.sandbox.java8;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RangeExample01 {
    public static void main(String[] args) {

        IntStream.rangeClosed(1, 10).forEach(System.out::print); // prints 12345678910

        // Print ints using Collectors joining
        System.out.println(
                IntStream.rangeClosed(1, 10)    // 1..10
                .mapToObj(Integer::toString) // convert to String to print
                .collect(Collectors.joining(", ", "[", "]")));  // prints [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        // range() print number less than the maximum
        System.out.println(
                IntStream.range(1, 10)      // 1..9
                .mapToObj(Integer::toString) // convert to String to print
                .collect(Collectors.joining(", ", "[", "]")));  // prints [1, 2, 3, 4, 5, 6, 7, 8, 9]

        System.out.println(
                IntStream.iterate(5, i-> i+1)   // start with 5, add 1  
                        .limit(5)               // limit 
                        .mapToObj(Integer::toString)    // convert to String to print
                        .collect(Collectors.joining(", ")));
    }

}
