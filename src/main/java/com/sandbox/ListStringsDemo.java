package com.sandbox;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.*;

/**
 * Exercise to add entries to List, Map and modify Map
 */
public class ListStringsDemo {

    public static void main( String [] args) {
        String [] contentsArr = { 
            "This is first Line ",
            "Requested by " + " Month", 
            "December" };
        List <String> contentsList = Arrays.asList(contentsArr).stream()
            .collect(Collectors.toCollection(LinkedList::new));
        
        contentsList
            .forEach(System.out::println);
        
        // Check for empty List
        String[] months = {};
        long count = Arrays.asList(months).stream()
        	.count();
        System.out.println("Number of months: " + count);
        
        // Check for null value and return default empty array
        String[] cities = null;
        long cityCount = Arrays.asList(
        		Optional.ofNullable(cities)
        			.orElseGet(() -> { 
        				String[] empty = new String[] {};	
        				return empty;
        				}
        			)
        		).stream()
        	.count();
        System.out.println("City Count: " + cityCount);
        
        // Check for null value and return default empty array
        String[] buses = null;
        long busCount = Arrays.asList(
        		Optional.ofNullable(buses)
        			.orElseGet( () -> { return new String[0]; } 
        			)
        		).stream()
        	.count();
        System.out.println("Bus Count: " + busCount);
        
    }
}
