package com.sandbox.java8;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;
import java.util.ArrayList;

// Class that contains an attribute which is used for filtering.
class Quote {
    public String name;
    public boolean isExposed;
    public Quote(String name, boolean isExposed) {
        this.name = name;
        this.isExposed = isExposed;
    }
    public boolean isExposed() {
        return isExposed;
    }
    
    public String toString(){
        return String.format("Quote:[%-20s]isExposed:[%5s]", name, isExposed);
    }
}

public class FilterExercise02 {
    public static void main(String []args) {
        char givenChar = 's';
        String state = "mississippi";

        long count = state.chars()
                .filter(i -> i == givenChar)
                .count();

        System.out.println(String.format("Found %d occurrences of %c in %s ",
                count, givenChar, state));
            
        String [] monthsArray = { "January", "February", "March", "May", "June", "July" };

        // simple test to show filtering on an array of objects.
        java.util.List <Quote> quotesList = new java.util.ArrayList<>();
        
        // set some quotes with an attribute which will be used for filtering. 
        int i=10;
        for (String month: monthsArray) {
            boolean isExposed = (i % 2) == 0;
            quotesList.add(new Quote(month, isExposed));
            i++;
        }
        // debug
        quotesList.stream()
            .forEach(System.out::println);
            
        // print only exposed quotes.
        System.out.println("Printing Exposed Quotes");
        quotesList.stream()
            .filter(q -> q.isExposed())
            .forEach(System.out::println);
        
        List <Box> boxList = new ArrayList<FilterExercise02.Box>();
        
        FilterExercise02 fexer02 = new FilterExercise02();
        Box b = fexer02.new Box();
    }
    
    public class Box {
        boolean isExposed;
    }
}
