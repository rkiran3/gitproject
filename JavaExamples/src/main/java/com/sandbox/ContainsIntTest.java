package com.sandbox;

import java.util.Arrays;
//import java.util.stream.Stream;

/**
 * Check for existence of Integer in an Array
 */
public class ContainsIntTest {

    public static void main( String [] args) {

        // Create an array of Integers
        Integer [] types = { new Integer(22), new Integer (33)  };

        // Convert to int value and check if number exists
        boolean contains = Arrays.asList(types).stream()
            .mapToInt(Integer::valueOf)            
            .anyMatch(i -> i == 24);
        assert(!contains);

        contains = Arrays.asList(new Integer [] {11, 22, 33}).stream()
            .mapToInt(Integer::valueOf)
            .anyMatch(i -> i == 33);
        assert(contains);
        
        contains = Arrays.asList(new Integer [] {11, 22, 33}).contains(33);
        
        System.out.println(contains);
        
    }
}