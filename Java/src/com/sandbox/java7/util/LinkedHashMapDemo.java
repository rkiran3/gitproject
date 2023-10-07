package com.sandbox.java7.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class LinkedHashMapDemo {
    public static void main(String [] args) {

        Map <String, Integer>linkedHashMap = new LinkedHashMap<String, Integer>();
        linkedHashMap.put("January", 31 );
        linkedHashMap.put("February", 28);
        linkedHashMap.put("March", 31);

        // Iterate HashMap
        Set <Map.Entry<String, Integer>> entrySet = linkedHashMap.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println("key = " + entry.getKey());
        }

        // Construct a List from Keys of that HashMap
        List <String>monthsList = new ArrayList<String>(linkedHashMap.keySet());
        assert "January".equals(monthsList.get(0));
        assert "February".equals(monthsList.get(1));
        assert "March".equals(monthsList.get(2));
    }
}
