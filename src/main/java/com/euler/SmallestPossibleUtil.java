package com.euler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SmallestPossibleUtil {

    /**
     * Given a number, return a hashmap of number of binary zeroes in each of them.
     */
    public static Map populateHolesHashMap(int num) {
        Map<Integer, Integer> binZeroesMap = new HashMap<>();
        
        for (int i=0; i<= num; i++) {
            String numstr = Integer.toBinaryString(i);
            System.out.println("Processing: " + numstr);
            Map<String, Long> elemMap = Pattern.compile("").splitAsStream(numstr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            
            elemMap.entrySet().stream()
                .forEach(e -> System.out.println("Key: " + e.getKey() + " Val: " + e.getValue()));

            return elemMap;
                
        }
        return binZeroesMap;
    }

    public static void main(String...args) {
        Map<Integer, Integer> binZeroesMap = populateHolesHashMap(10);
    }
    
}
