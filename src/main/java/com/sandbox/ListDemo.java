package com.sandbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

/**
 * Exercise to add entries to List, Map and modify Map
 */
public class ListDemo {

    public static void main(String[] args) {
        Map<String, List<String>> myMap = new HashMap<>(); // Map to Store Key, Value
        List<String> summerMonthsList = new ArrayList<String>();

        summerMonthsList.add("June" + " Month");
        summerMonthsList.add("July");

        // Store the list in the Map, using a String Key
        myMap.put("months", summerMonthsList);

        // Now, get the Object from Map and add another entry
        List<String> secondList = myMap.get("months");
        secondList.add("August");

        assert (summerMonthsList == secondList);

        String message = "jan:31|feb: 28";
        
        // Split delimited string and convert to Stream
        Map<String, String> myMonthMap = Stream.of(message.split("\\|"))
                // .peek(m -> System.out.printf("MonthDay:[%s]\n", m))
                // split again on : delimiter
                .map(s -> s.split(":"))
                // print the tokens
                // .peek(md -> System.out.printf("Month [%s] Day [%s]\n", md[0].trim(),
                // md[1].trim()))
                // collect tokens into a Map
                .collect(Collectors.toMap(t -> t[0].trim(), t -> t[1].trim()));

        // test generated output
        assert (myMonthMap.size() == 2);
        assert (myMonthMap.get("jan").equals("31"));
        assert (myMonthMap.get("feb").equals("28"));
        
        String janMonthAndDay = "Jan:31";
        Map<String, String> monthDayMap = Stream.of(janMonthAndDay)
                .map(s -> s.split(":", 2))
                // .peek((k) -> System.out.println(k[0] + " " + k[1]))
                .collect(Collectors.toMap(a -> a[0], a -> a[1]));
                // .forEach((k) -> System.out.println(k[0] + " " + k[1]));
        assert (monthDayMap != null);
        
        System.out.println("Program complete");
    }
}
