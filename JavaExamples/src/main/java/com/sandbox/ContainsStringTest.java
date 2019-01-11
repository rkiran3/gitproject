package com.sandbox;

import java.util.Arrays;
import java.util.List;
//import java.util.stream.Stream;

/**
 * Check for existence of String in an Array
 */
public class ContainsStringTest {

    public static void main( String [] args) {

        // Create an array of Strings
        List <String> colors = Arrays.asList("Red", "Blue", "Green");

        // Convert to int value and check if number exists
        boolean contains = colors.stream()
            .anyMatch(c -> c.equals("Red"));
        assert(contains);

        System.out.println(contains);
        
    }
}
