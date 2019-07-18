package com.sandbox.java8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CollectorExercise06 {
    public static void main(String [] args) {
        String [] monthsArray = { "Jan", "Feb", "Mar"};
        List <String> monthsList = new ArrayList<>(Arrays.asList(monthsArray));

        // Test for valid string entries, should return "Jan,Feb,Mar"
        String result1 = monthsList.stream()
                .filter(Objects::nonNull)  
                .filter(e -> e.length() > 0)
                .collect(Collectors.collectingAndThen(Collectors.joining(","), 
                        str -> {
                          if (str.isEmpty()) {
                              return null;
                          }
                          return str;
                        }));
        assertEquals("Jan,Feb,Mar", result1);

        // Test for empty entries, should return "Jan, Mar"
        String [] emptyMonthsArray = { "Jan", "", "Mar"};
        String result2 = Arrays.asList(emptyMonthsArray).stream()
                .filter(Objects::nonNull)
                .filter(e -> e.length() > 0)
                .collect(Collectors.collectingAndThen(Collectors.joining(","), 
                        str -> {
                          if (str.isEmpty()) {
                              return null;
                          }
                          return str;
                        }));
        assertEquals("Jan,Mar", result2);
        

        // Test for null string entries, should return "Jan,Mar"
        String [] emptyMonthsArray3 = { "Jan", null, "Mar"};
        String result3 = Arrays.asList(emptyMonthsArray3).stream()
                .filter(Objects::nonNull)
                .filter(e -> e.length() > 0)
                .collect(Collectors.collectingAndThen(Collectors.joining(","), 
                        str -> {
                          if (str.isEmpty()) {
                              return null;
                          }
                          return str;
                        }));
        assertEquals("Jan,Mar", result3);

        
        // Test for null string entries, should return null
        String [] nullMonthsArray = { null, null, null};
        String result4 = Arrays.asList(nullMonthsArray).stream()
                .filter(Objects::nonNull)
                .filter(e -> e.length() > 0)
                .collect(Collectors.collectingAndThen(Collectors.joining(","), 
                        str -> {
                          if (str.isEmpty()) {
                              return null;
                          }
                          return str;
                        }));
        assertNull(result4);
    }
}
