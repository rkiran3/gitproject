package com.sandbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**
 * Exercise to add entries to List, Map and modify Map
 */
public class ListDemo {

    public static void main( String [] args) {
        Map<String, List<String>> myMap = new HashMap<String, List<String>>(); // Map to Store Key, Value
        String [] months = { "November", "December" };
        List <String> winterMonths = Arrays.asList(months);
        
        List <String>summerMonthsList = new ArrayList<String>();
        
        summerMonthsList.add("June");
        summerMonthsList.add("July");
            
        // Store the list in the Map, using a String Key
        myMap.put("months", summerMonthsList);
        
        // Now, get the Object from Map and add another entry
        List <String>secondList = myMap.get("months");
        secondList.add("August");
        
        System.out.println("Lists should be same " + (summerMonthsList == secondList));
        assert(summerMonthsList == secondList);
        
    }
}
