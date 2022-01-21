package com.sandbox;

import java.util.List;
import java.util.logging.Logger;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Construct a list of even numbers
 */ 
public class ConstructListDemo {
	public final static Logger log = Logger.getLogger(ConstructListDemo.class.getName());
	
    public static void main( String [] args) {
        // Create an array of Integers
        List <Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        
        List<Integer> evenList = list.stream()
            .filter(i -> (i % 2 == 0))
            .collect(Collectors.toList());
            //.forEach(System.out::println);
           
        assert (evenList.size() == 2); // found two even entries
        assert (evenList.get(0) == 2);
        assert (evenList.get(1) == 4);

        // prints 2 4 
        evenList.stream()
            .forEach(e -> System.out.printf("%d ", e));
            
        Integer first = evenList.stream()
        		.limit(1)
        		.findFirst()
        		.get();
        assert first.equals(2);
    }
}
