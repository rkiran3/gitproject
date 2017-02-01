package com.sandbox.java8.util;

import java.util.Arrays;
import java.util.stream.*;

public class ArraysDemo {
    public static void main(String [] args) {
        try {
            // Create Array of Strings
            String [] months = { "Jan", "February", "March" };

            // Create a Stream of String from the Array
            Stream <String> stringStream = Arrays.stream(months);

            // Count
            assert months.length == stringStream.count();

            // Create a Stream from the Array
            Stream <String> stringStream2 = Arrays.stream(months);

            // Now, go through each element of Stream to find months ending with "y"
            stringStream2
                .filter(s-> s.endsWith("y"))
                .forEach(System.out::println);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } // main ends
} // classTest ends
