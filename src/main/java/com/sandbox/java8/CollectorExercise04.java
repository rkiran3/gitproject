package com.sandbox.java8;

import java.util.stream.*;
//import java.util.stream.Collectors;
import java.util.*;

/**
    * collect only entries in a multiline
    * that do not start with an identifier.
 */

public class CollectorExercise04 {

    // create a multiline that has an identifier
    // input
    public static String demoStr = "--Firstline\n" +
"1100 \n" +
"2200 \n" +
"--SecondLine\n" +
"3333\n" +
"4444\n";

    public static void main(String[] args) {
    
        String [] tokens = demoStr.split("\n");
        //System.out.println(tokens);
        List <String> accounts = Arrays.asList(tokens).stream()
            .filter(w -> !w.startsWith("--"))
            .collect(Collectors.toList());

        // [1100, 2200, 3333, 4444]
        System.out.println(accounts);
    }
}
    