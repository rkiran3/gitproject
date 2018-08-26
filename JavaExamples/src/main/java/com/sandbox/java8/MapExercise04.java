package com.sandbox.java8;

import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * Process a stream of Strings, each String has two words separated by comma
 * print only the second entry
 * Input:   "jan,31", "feb,28", "mar,28"   // retrieve second entry only
 * Output:  "31,28,28" 
 */
public class MapExercise04 {
    public static void main(String [] args) {
        String result = Stream.of("jan,31", "feb,28", "mar,28" )
            .map(w -> w.split(",")[1])
            .collect(Collectors.joining(","));
        
        String expected = "31,28,28";
        assert(result.equals(expected));
    }
}
