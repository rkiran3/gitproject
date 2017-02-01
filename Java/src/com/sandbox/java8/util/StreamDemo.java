package com.sandbox.java8.util;

import java.util.Arrays;
import java.util.stream.*;
import java.util.OptionalInt;

public class StreamDemo {
    public static void main(String [] args) {
        try {
            // Create Array of Strings
            String [] months = { "Jan", "February", "March" };

            // Create a Stream of String from the Array
            Stream <String> monthsStream = Arrays.stream(months);

            // Count
            assert months.length == monthsStream.count();

            // To create a stream of ints
            int [] numbers = { 1, 2, 3, 4, 5};
            IntStream intStream = Arrays.stream(numbers);

            // A filter acts on each element and returns elements
            // which are divisible by 2
            intStream
                .filter(e -> e%2 == 0)
                .forEach(System.out::println);

            // Create a Stream of ints to contain 1, 2, 3, 4
            assert 4 == IntStream.range(1,5).count();

            // rangeClosed(1,5) creates a stream of 1, 2, 3, 4, 5
            assert 5 == IntStream.rangeClosed(1,5).count();

            // Lets get first entry
            // OptionalInt is container which may/may-not contain
            // an int
            OptionalInt result = IntStream.range(1,5).findFirst();
            // since we are creating a list 1, 2, 3, 4
            // there will be an OptionalInt so isPresent() is true.
            assert (result.isPresent());
            if (result.isPresent()) {
                assert 1 == result.getAsInt();
            }

            // IntStream.range(1,5) returns 1,2,3,4
            assert 4 == IntStream.range(1,5).max().getAsInt();

            // IntStream.rangeClosed(1,5) returns 1,2,3,4,5
            assert 5 == IntStream.rangeClosed(1,5).max().getAsInt();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } // main ends
} // classTest ends
