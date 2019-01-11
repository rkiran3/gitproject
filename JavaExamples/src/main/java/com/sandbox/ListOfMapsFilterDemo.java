package com.sandbox;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * Process a List of Maps and filter based on criteria
 */ 
public class ListOfMapsFilterDemo {

    public static void main( String [] args) {
        
        List <Map<String, Object>> listOfMaps = new ArrayList<>();
        
        // Create a Map to store attributes
        Map <String, Object> tmpMap = new HashMap<String, Object>();
        tmpMap.put("revenue", new Integer(21));
        tmpMap.put("valid", new Boolean(false));
        // Add the map to List
        listOfMaps.add(tmpMap);
        
        Map <String, Object> tmpMap2 = new HashMap<String, Object>();
        tmpMap2.put("revenue", new Integer(33));
        tmpMap2.put("valid", new Boolean(true));
        // Add the map to List
        listOfMaps.add(tmpMap2);
        
        // Now filter the List of Maps and get only the "valid" entries
        List <Map<String, Object>> resultList = listOfMaps.stream()
            .filter(m -> (Boolean)m.get("valid"))
            .collect(Collectors.toList());
        
        // Verify results
        if (resultList.size() > 0) {
            System.out.println("Found values: ");
            resultList.stream()
                .forEach(m -> System.out.println((Integer)m.get("revenue")));
            
            // we should have one "valid" entry 
            assert (resultList.size() == 1);
            // this entry should be same entry that was added earlier
            assert (resultList.get(0).equals(tmpMap2));
        }
        
    }
}
