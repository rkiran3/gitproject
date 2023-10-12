package com.sandbox;

import java.util.stream.Stream;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Exercise to execute a method for each entry in list
 */
 
class Month {
    public String name;
    public Month(String name) {this.name = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String toString() { return this.name; }
}
public class ExecMethodForEachDemo {
    
    // execute this method for each entry
    public static void display(Month month) { 
        System.out.println(month.getName()); 
    }
    
    public static String displayStr(Month month) { 
        return month.getName();
    }
    
    public static void main( String [] args) {
        String [] monthsArr = { "November", "December" };

        Stream <Month> stream = Arrays.asList(monthsArr).stream()
            .map(Month::new);
            
        List <String> allMonthsList = stream
            .map(ExecMethodForEachDemo::displayStr)
            .collect(Collectors.toList());
            
        System.out.println(allMonthsList);
        
        // Collect all entries and generate a string
        stream = Arrays.asList(monthsArr).stream()
            .map(Month::new);
        String allMonths = stream
            .map(Object::toString)
            .collect(Collectors.joining(","));
            
        assert(allMonths.equals("November,December"));
    }
}
