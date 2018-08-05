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
 
public class ListOfMapsTest {

    public static void main( String [] args) {
        List <Map<String, Integer>> listOfMaps = new ArrayList<Map<String, Integer>>();
        
        // Create an array of Integers
        Map <String, Integer> tmpMap = new HashMap<String, Integer>();
        tmpMap.put("revenue", 21);
        tmpMap.put("loss", 3);
        // Add the map to List
        listOfMaps.add(tmpMap);
        
        Map <String, Integer> tmpMap2 = new HashMap<String, Integer>();
        tmpMap2.put("revenue", 00);
        tmpMap2.put("loss", 20);
        // Add the map to List
        listOfMaps.add(tmpMap2);
                
        long count = listOfMaps.stream()
            .map(m ->m.entrySet().stream()
                .peek(mtmp -> mtmp.getKey().equals("revenue"))
                .filter(mtmp -> mtmp.getKey().equals("revenue"))                
                )
            .limit(1)
            .count();
        if (count >0){
            System.out.println("Found entry with value");
        }
        
    }
}
