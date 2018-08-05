package com.sandbox;

import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**
 * Exercise to execute a method for each entry in list
 */
 
class Month {
    public String name;
    public Month(String name) {this.name = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
public class ExecMethodForEachDemo {
    
    // execute this method for each entry
    public static void display(Month month) { 
        System.out.println(month.getName()); 
    } 
    
    public static void main( String [] args) {
        String [] monthsArr = { "November", "December" };
        //List <String> monthsListStr = Arrays.asList(monthsArr);
        Stream <Month> stream = Arrays.asList(monthsArr).stream()
            .map(Month::new);
        stream
            .forEach(m -> display(m));
    }
}
