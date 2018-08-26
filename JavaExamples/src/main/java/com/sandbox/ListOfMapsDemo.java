package com.sandbox;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * Process a List of Maps
 */ 
public class ListOfMapsDemo {

    public static void main( String [] args) {
        
        List <Map<String, Integer>> listOfMaps = new ArrayList<Map<String, Integer>>();
        
        // Create a Map to store attributes
        Map <String, Integer> tmpMap = new HashMap<String, Integer>();
        tmpMap.put("revenue", 21);
        tmpMap.put("loss", 3);
        // Add the map to List
        listOfMaps.add(tmpMap);
        
        // Create another Map to add to List
        Map <String, Integer> tmpMap2 = new HashMap<String, Integer>();
        tmpMap2.put("revenue", 00);
        tmpMap2.put("loss", 20);
        // Add the map to List
        listOfMaps.add(tmpMap2);

        // Process List of Maps
        List <Integer> revenueList = listOfMaps.stream()
            .map(x -> x.get("revenue"))     // process each entry, get desired attribute
            .collect(Collectors.toList());  //
        revenueList.stream()
            .forEach(System.out::println);
        
        // total revenue
        Integer sum = revenueList.stream()
            .reduce(0, Integer::sum);       // total all the revenue amounts
        System.out.println("Sum: " + sum);
        
        // another example to get list of ids from a List of Maps, where each Map contains
        // an attribute of "id"
        List <Map<String, Integer>> listOfMonthMaps = new ArrayList<Map<String, Integer>>();
        
        // Create a Map to store attributes
        Map <String, Integer> janMap = new HashMap<String, Integer>();
        janMap.put("days", 31);
        // Add the map to List
        listOfMonthMaps.add(janMap);
        
        // Create another Map to add to List
        Map <String, Integer> febMap = new HashMap<String, Integer>();
        febMap.put("days", 28);
        // Add the map to List
        listOfMonthMaps.add(febMap);

        // Process List of Maps
        List <Integer> daysList = listOfMonthMaps.stream()
            .map(x -> x.get("days"))     // process each entry, get desired attribute
            .collect(Collectors.toList());  //
        
        assert(Arrays.asList(new Integer[] { 31, 28 }).equals(daysList));
    }
}
