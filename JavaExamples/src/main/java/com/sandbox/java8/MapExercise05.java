package com.sandbox.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapExercise05 {

    public static void main(String[] args) {
        List <Map<String, Integer>> listOfMaps = new ArrayList<Map<String, Integer>>();
        
        // Create a Map to store attributes
        Map <String, Integer> tmpMap = new HashMap<String, Integer>();
        tmpMap.put("revenue", 21);
        tmpMap.put("loss", 3);
        tmpMap.put("inventory", 100);
        
        // Create another Map
        Map <String, Integer> tmpMap2 = new HashMap<String, Integer>();
        tmpMap2.put("revenue", 01);
        tmpMap2.put("loss", 20);
        tmpMap2.put("inventory", 20);

        // Create another Map
        Map <String, Integer> tmpMap3 = new HashMap<String, Integer>();
        tmpMap3.put("revenue", 01);
        tmpMap3.put("loss", 20);
        tmpMap3.put("inventory", 122);

        // Add all maps to List
        listOfMaps.add(tmpMap);
        listOfMaps.add(tmpMap2);
        listOfMaps.add(tmpMap3);

        // Process each entry (i.e Map) in List 
        //listOfMaps.stream()
        //    .forEach(
        //            entry -> entry.entrySet().forEach(System.out::println));

        long count = tmpMap2.entrySet().stream()
            .filter(entry -> entry.getKey().equals("revenue") && entry.getValue() > 0)
            .count();
        assert(count == 3);

        // number of entries having inventory > 100 
        count = tmpMap2.entrySet().stream()
                .filter(entry -> entry.getKey().equals("revenue") && entry.getValue() >= 100)
                .count();
        assert(count == 2);

        // number of entries having key "revenue"
        Map<String, Integer> filteredMap = tmpMap2.entrySet().stream()
                .filter(entry -> entry.getKey().equals("revenue"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        assert(filteredMap.size() == 3);
        
        // number of entries having key "inventory" and inventory >= 100
        List<Map<String, Integer>> listOfItemsWithInv = listOfMaps.stream()
            .filter(entry -> 
                entry.containsKey("inventory") && 
                entry.get("inventory") >= 100)
            .collect(Collectors.toList());
        assert(listOfItemsWithInv.size() == 2);
        
        
        //System.out.println("Printing filtered list of maps");
        //listOfItemsWithInv
        //   .forEach(e -> e.entrySet().forEach(System.out::println));
    }

}
