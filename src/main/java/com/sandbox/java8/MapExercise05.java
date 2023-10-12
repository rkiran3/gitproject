package com.sandbox.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Input:
{loss=3, revenue=21, inventory=100}
{loss=20, revenue=1, inventory=20}
{loss=20, revenue=1, inventory=122}
[{loss=3, revenue=21, inventory=100}, {loss=20, revenue=1, inventory=20}, {loss=20, revenue=1, inventory=122}]

	Output:  
		Revenue > 0
		count = 3
		
		inventory >=100
		count = 1
 * 
 */

public class MapExercise05 {
    public static Map<String, Object> loadMap() {
        Map<String, Object> myMap = new HashMap<String, Object>();
        myMap.put("ITEM", Integer.valueOf(44));
        myMap.put("NUMBER", String.valueOf(44));

        return myMap;
    }

    public static void main(String[] args) {
        List<Map<String, Integer>> listOfMaps = new ArrayList<Map<String, Integer>>();

        // Create a Map to store attributes
        Map<String, Integer> tmpMap = new HashMap<String, Integer>();
        tmpMap.put("revenue", 21);
        tmpMap.put("loss", 3);
        tmpMap.put("inventory", 100);
        System.out.println(tmpMap);

        // Create another Map
        Map<String, Integer> tmpMap2 = new HashMap<String, Integer>();
        tmpMap2.put("revenue", 01);
        tmpMap2.put("loss", 20);
        tmpMap2.put("inventory", 20);
        System.out.println(tmpMap2);

        // Create another Map
        Map<String, Integer> tmpMap3 = new HashMap<String, Integer>();
        tmpMap3.put("revenue", 01);
        tmpMap3.put("loss", 20);
        tmpMap3.put("inventory", 122);
        System.out.println(tmpMap3);

        // Add all maps to List
        listOfMaps.add(tmpMap);
        listOfMaps.add(tmpMap2);
        listOfMaps.add(tmpMap3);
        System.out.println(listOfMaps);

        long count = tmpMap2.entrySet().stream()
                .filter(entry -> entry.getKey().equals("revenue") && entry.getValue() > 0)
                .count();
        assert (count == 1);

        // number of entries having inventory > 100
        count = tmpMap2.entrySet().stream()
                .filter(entry -> entry.getKey().equals("revenue") && entry.getValue() >= 100)
                .count();
        assert (count == 0);

        // number of entries having key "revenue"
        Map<String, Integer> filteredMap = tmpMap2.entrySet().stream()
                .filter(entry -> entry.getKey().equals("revenue"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        assert (filteredMap.size() == 1);

        // number of entries having key "inventory" and inventory >= 100
        List<Map<String, Integer>> listOfItemsWithInv = listOfMaps.stream()
                .filter(entry -> entry.containsKey("inventory") &&
                        entry.get("inventory") >= 100)
                .collect(Collectors.toList());
        assert (listOfItemsWithInv.size() == 2);

        // MapExercise05 mapExercise = new MapExercise05();
        Map<String, Object> initialMap = new HashMap<String, Object>();

        initialMap.putAll(MapExercise05.loadMap());
        System.out.println(initialMap);

        Map<String, Integer> sortedMapByKey = tmpMap2.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
        System.out.println(sortedMapByKey);
    }

}
