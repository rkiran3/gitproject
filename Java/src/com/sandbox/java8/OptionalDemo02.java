package com.sandbox.java8;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.*;
import java.util.Optional;

public class OptionalDemo02 {
    public static void main(String [] args) {
        String input = null;
        String holidayMonth = "December";
        
        // conventional
        String value = input != null ? input : holidayMonth;
        System.out.println(value); // will be December
        if (!value.equals("December")) {
            System.out.println("test fails");
        }
        
        // using optional, in this example 
        // create an Optional using that value, if it is null use "orElse"
        value = Optional.ofNullable(input)
            .orElse(holidayMonth);
        System.out.println(value); // will be December
        if (!value.equals("December")) {
            System.out.println("test fails");
        }

        
        // Show how to use Optional for successful processing
        input = "Floating Holiday";
        value = Optional.ofNullable(input)
            .map(e -> (String)e.substring(0, 10) + "...") // since input has a value, we would return truncated value
            .orElse(holidayMonth);
        System.out.println(value); // 
        if (!value.equals("Floating H...")) {
            System.out.println("test fails");
        }

        
        // Create list of users that can be used in a Stream to be searched.
        List <String> names = Arrays.asList( "guest", "admin" );

        // it will find guest
        boolean found = Optional.ofNullable(names)
            .filter(n -> n.stream()
                .anyMatch(e -> e.equals("guest"))
                )
            .isPresent(); // will return true since it finds "guest"
        System.out.println("Found guest: " + found);

        
        names = null; // change value to null and search - which will be unsuccessful
        found = Optional.ofNullable(names) // names is null 
            .filter(n -> n.stream()
                .anyMatch(e -> e.equals("guest"))
                )
            .isPresent(); // will return false since list is null
        System.out.println("Found guest: " + found);
        
    }
}
