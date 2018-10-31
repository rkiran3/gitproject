package com.sandbox.java8;

import java.util.stream.*;
//import java.util.stream.Collectors;
import java.util.*;

/**
 * Show how to create a String that is separated by line.separator.
 */
public class CollectorExercise03 {
    public static void main(String[] args) {
        List<String> contents = new LinkedList<String>();
        contents.add("JAN");
        contents.add("FEB");
    
        String months = contents.stream()
            .collect(Collectors.joining(System.getProperty("line.separator")));

        System.out.println("Months: "+ months);
    }
}
