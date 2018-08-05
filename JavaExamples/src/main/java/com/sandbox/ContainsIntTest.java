package com.sandbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * Check for existence of Integer in an Array
 */
 
public class ContainsIntTest {

    public static void main( String [] args) {
        // Create an array of Integers
        Integer [] types = { new Integer(22), new Integer (33)  };
        
        // Convert to int value and check if particular number exists
        // 23 does exist, however 24 does not exist. 
        boolean contains = Arrays.asList(types).stream()            
            .mapToInt(Integer::valueOf)            
            .anyMatch(i -> i == 24);
            
            
        System.out.println("contains = " + contains);
    }
}
