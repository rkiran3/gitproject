package com.sandbox.java8;

/**
 * OptionalExercise01
 */
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * OptionalExercise01
 */
public class OptionalExercise01 {
    /**
     * Run the exercises to ensure we got the right answers
     *
     * @throws java.io.IOException
     */
    public void runExercises() throws IOException {
        System.out.println("Running exercise 1 solution...");
        exercise1();
        
        exercise2();
    }

    /**
     */
    private void exercise1() {
        // test1: check for null string
        String status = null;
        String result = Optional.ofNullable(status)  // if status is null, then return empty string
            .orElse("");
            
        if (!result.equals("")) {
            System.out.println("Exercise01: Test 1 Fails");
        }
        
        // test2: check for existing string        
        status = "success";
        result = Optional.ofNullable(status)  // if status is not null, then return status string
            .orElse("");
            
        if (!result.equals("success")) {
            System.out.println("Exercise01: Test 2 Fails");
        }
        
        // test3: check for Integer
        Integer defaultDays = Integer.valueOf(90);
        Integer current = null;
        Integer days = Optional.ofNullable(current)
            .orElse(defaultDays);
            
        if (!days.equals(defaultDays)) {
            System.out.println("Exercise01: Test 3 Fails");
        }
        
    }

    private void exercise2() {
        // Inner class for testing List 
        class Cover {
            private List <String> coverList;

            public void setCoverList(List <String> coverList) {
                this.coverList = coverList;
            }
            
        }

        Cover cover = new Cover();
        List <String> namesList = Stream.of("January", "February")
                .collect(Collectors.toList());
        
        //namesList.forEach(System.out::println);
        cover.setCoverList(namesList);
        cover.setCoverList(null);
                
        System.out.println(" Test: " );
        
    }

    /**
     * Main entry point for application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        OptionalExercise01 exercises = new OptionalExercise01();
        exercises.runExercises();
    }
}

