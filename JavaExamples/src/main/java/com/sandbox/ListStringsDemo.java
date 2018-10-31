package com.sandbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.*;

/**
 * Exercise to add entries to List, Map and modify Map
 */
public class ListStringsDemo {

    public static void main( String [] args) {
        Map<String, List<String>> myMap = new HashMap<String, List<String>>(); // Map to Store Key, Value
        String [] contentsArr = { 
            "This is first Line ",
            "Requested by " + " Month", 
            "December" };
        List <String> contentsList = Arrays.asList(contentsArr).stream()
            .collect(Collectors.toCollection(LinkedList::new));
        
        contentsList
            .forEach(System.out::println);
    }
}
