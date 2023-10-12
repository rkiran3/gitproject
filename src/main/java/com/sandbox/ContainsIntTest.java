package com.sandbox;

import java.util.Arrays;

/**
 * Check for existence of Integer in an Array
 */
public class ContainsIntTest {

    public static void main( String [] args) {

        // Create an array of Integers
        Integer [] types = { Integer.valueOf(22), Integer.valueOf(33)  };

        // Convert to int value and check if number exists
        boolean contains24 = Arrays.asList(types).stream()
            .mapToInt(Integer::valueOf)
            .anyMatch(i -> i == 24);
        assert(!contains24);

        boolean contains33 = Arrays.asList(new Integer [] {11, 22, 33}).stream()
            .mapToInt(Integer::valueOf)
            .anyMatch(i -> i == 33);
        assert(contains33);
        
        contains33 = Arrays.asList(new Integer [] {11, 22, 33}).contains(33);
        assert(contains33);
        
    }
}
