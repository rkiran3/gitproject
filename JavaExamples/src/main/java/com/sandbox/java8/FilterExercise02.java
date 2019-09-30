package com.sandbox.java8;

//import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.LinkedHashMap;
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
        Map <String, Object> dict = new LinkedHashMap<>();
        dict.put("January", null);
        dict.put("February", new Integer(28));
        dict.put("March", null);
        
        Map <String, Object> newMap = dict.entrySet().stream()
            .filter(m -> m.getValue() != null)
            .collect(
                    Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
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
