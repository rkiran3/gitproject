package com.codingbat.functional2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Given a list of integers, return a list of those numbers, omitting any that are between 13 and 19 inclusive.

noTeen([12, 13, 19, 20]) => [12, 20]
noTeen([1, 14, 1]) => [1, 1]
noTeen([15]) => []
 *
 */

public class NoTeen {

    public static List <Integer> noTeen(int [] inArray) {
        
        List <Integer> outList = IntStream.of(inArray)
                .boxed()
                //.peek(i -> System.out.println("Processing: " + i))
                .filter(i -> (i.intValue() < 13 || i.intValue() > 19) )
                //.peek(i -> System.out.println("filtered: " + i))
                .collect(Collectors.toList());
        
        return outList;
    }
    
    public static void main(String[] args) {
        
        // noTeen([12, 13, 19, 20]) => [12, 20]
        System.out.println(noTeen(new int [] { 12, 13, 19, 20 }).stream()
            .map(String::valueOf)
            .collect(Collectors.joining(",",    "[",    "]")));

        // noTeen([1, 14, 1]) => [1, 1]
        System.out.println(noTeen(new int [] { 1, 14, 1 }).stream()
            .map(String::valueOf)
            .collect(Collectors.joining(",",    "[",    "]")));
    }

}
