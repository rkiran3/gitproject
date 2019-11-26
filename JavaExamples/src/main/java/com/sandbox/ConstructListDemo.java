package com.sandbox;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * Construct a list of even numbers
 */ 
public class ConstructListDemo {

    private static Integer demoInteger = new Integer(22);
    
    public static void main( String [] args) {
        // Create an array of Integers
        List <Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        
        List<Integer> evenList = list.stream()
            .filter(i -> i %2 ==0)
            .collect(Collectors.toList());
            //.forEach(System.out::println);
           
        // prints 2 4 
        evenList.stream()
            .forEach(e -> System.out.printf("%d ", e));
            
        
        assert evenList.size() == 2; // found two even entries 
        
        Integer first = evenList.stream().limit(1).findFirst().get();
        assert first.equals(2);
    }
}
