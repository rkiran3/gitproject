package com.sandbox.java8;

//import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class FilterExercise02 {
    public static void main(String []args) {
        FilterExercise02 fexer02 = new FilterExercise02();

        char givenChar = 's';
        String state = "mississippi";
        long count = state.chars()
                .filter(i -> i == givenChar)
                .count();
        //assertEquals(count, 4);

        
        String [] monthsArray = { "January", "February", "March", "May", "June", "July" };

        // simple test to show filtering on an array of objects.
        java.util.List <Month> monthList = Arrays.asList(monthsArray).stream()
                // create new classes with their name and if name ends with y boolean attribute 
                .map(m -> fexer02.new Month(m, m.endsWith("y")))
                .collect(Collectors.toList());
        
        List <String> monthsEndsY = monthList.stream()
                //.peek(m -> System.out.println("Processing: " + m))
                .filter(Month::isEndsWithY)
                //.peek(m -> System.out.println("EndsWithY: " + m))
                .map(Month::getName)
                .collect(Collectors.toList());
        
        String[] expected = { "January", "February", "May", "July" };
        //assertArrayEquals(expected, monthsEndsY.toArray());
        
        // another example to filter out null values
        // Input: { "January": null,   "February": Integer(28), "March": null }
        // Output:  { "February": Integer(28) }
        Map <String, Object> dict = new LinkedHashMap<>();
        dict.put("January", null);
        dict.put("February", new Integer(28));
        dict.put("March", null);        
        Map <String, Object> newMap = dict.entrySet().stream()
            .filter(m -> m.getValue() != null)
            .collect(
                    Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // Filter map entries and get the value associated with Key 
        // Input: { "December": "Cold", "January": "Colder", "February" : "Coldest" }
        // key = February
        // expected: "Coldest"
        Map <String, String> demoMap = new HashMap<>();
        demoMap.put("December", "Cold");
        demoMap.put("January", "Colder");
        demoMap.put("February", "Coldest");
        final String monthKey = "February";
        String condition = demoMap.entrySet().stream()
            .filter(m -> m.getKey().equals(monthKey))
            .map(m -> m.getValue())
            .findFirst()            
            .orElse(null);
        System.out.println(condition);
        if (!condition.equals("Coldest")) {
            System.out.println("Test Fails, expected Coldest for month February");
        }        
        
        // Input: { "December": "Cold", "January": "Colder", "February" : "Coldest" }
        // key = January
        // expected: "Colder"
        final String monthKey2 = "January";
        condition = demoMap.entrySet().stream()
            .filter(m -> m.getKey().equals(monthKey2))
            .map(m -> m.getValue())
            .findFirst()            
            .orElse(null);
        System.out.println(condition);
        if (!condition.equals("Colder")) {
            //System.out.println("Test Fails, expected Coldest for month February");
        }
        

        // Input: { "December": "Cold", "January": "Colder", "February" : "Coldest" }
        // check for non exist key = March
        // expected: null
        final String nonexistmonth = "March";
        condition = demoMap.entrySet().stream()
            .filter(m -> m.getKey().equals(nonexistmonth))
            .map(m -> m.getValue())
            .findFirst()            
            .orElse(null);
        System.out.println(condition);
        if (condition != null) {
            System.out.println("Test Fails, expected null");
        }
        
        
        // Filter map entries and get the value associated with Key 
        Map <String, String> demoMap2 = new HashMap<>();
        demoMap2.put("December", "Cold   ");
        demoMap2.put("January", "Colder ");
        demoMap2.put("February", "Coldest               ");
        
        demoMap2.entrySet()
            .forEach(entry -> System.out.printf("[%s]\n", entry.getValue()));
        
        demoMap2.entrySet().forEach( entry -> 
            entry.setValue(entry.getValue().trim()));
        
        demoMap2.entrySet()
            .forEach(entry -> System.out.printf("[%s]\n", entry.getValue()));
        
        demoMap2.entrySet().stream()
            .filter(entry -> entry.getValue() instanceof String)
            //.forEach(entry -> System.out.printf("[%s]\n", entry.getValue()));
            .forEach(entry -> entry.setValue(entry.getValue().trim()));

        // Filter map entries and get the value associated with Key 
        Map <String, Object> demoMap3 = new HashMap<>();
        demoMap3.put("December", null);
        demoMap3.put("January", "Colder         ");
        demoMap3.put("February", new Integer(23));

        demoMap3.entrySet().stream()
            .filter(entry -> entry.getValue() instanceof String)
            //  .forEach(entry -> System.out.printf("[%s]\n", entry.getValue()));
            .forEach(entry -> entry.setValue(((String)entry.getValue()).trim()));

        demoMap3.entrySet().stream()
            .filter(entry -> entry.getValue() instanceof String)
            //.forEach(entry -> System.out.printf("[%s]\n", entry.getValue()));
            .forEach(entry -> System.out.println(entry.getValue()));

        
        //assertTrue(newMap.size() ==  1);
        //assertTrue(newMap.containsKey("February"));
        
        // another way to remove entries with null values is to use removeIf
        dict.values().removeIf(Objects::isNull);
    }
    
    public class Month {
        private String name;
        private boolean endsWithY;
        public Month(String name, boolean endsWithY) {
            this.setName(name);
            this.endsWithY = endsWithY;
        }
        
        public String toString(){
            return String.format("%s", getName());
        }
        public boolean isEndsWithY() {
            return endsWithY;
        }
        public void setEndsWithY(boolean endsWithY) {
            this.endsWithY = endsWithY;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
