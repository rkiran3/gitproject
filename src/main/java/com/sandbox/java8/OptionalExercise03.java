package com.sandbox.java8;

/**
 * OptionalExercise03
 */
import java.io.*;
import java.util.*;

/**
 * OptionalExercise03
 */
public class OptionalExercise03 {
    /**
     * Run the exercises to ensure we got the right answers
     *
     * @throws java.io.IOException
     */
    public void runExercises() throws IOException {
        System.out.println("Running exercise 1 solution...");
        exercise1();
    }

    /**
     */
    private void exercise1() {
    	
        // check for existing Key with Boolean.TRUE
        Map <String, Object>itemMap = new HashMap <String, Object>();
        itemMap.put("EXISTS", Boolean.TRUE);
        boolean exists = Optional.ofNullable((Boolean)itemMap.get("EXISTS"))	// evaluates to TRUE
            .orElse(false);
        if (!exists) {
            System.out.println("Test 1 Fails");
        }
        
        itemMap.put("EXISTS", Boolean.FALSE);
        exists = Optional.ofNullable((Boolean)itemMap.get("EXISTS"))  // evaluates to FALSE
            .orElse(false);
        if (exists) {
            System.out.println("Test 1.1 Fails");
        }

        
        // check for non existing key
        itemMap.remove("EXISTS");
        exists = Optional.ofNullable((Boolean)itemMap.get("EXISTS"))
        		.orElse(false);
        if (exists) {
            System.out.println("Test 2 Fails");
        }
        
        // check for existing key with null value
        itemMap.put("EXISTS", null);
        exists = Optional.ofNullable((Boolean)itemMap.get("EXISTS"))
            .orElse(false);
        if (exists) {
            System.out.println("Test 3 Fails");
        }
    }

    /**
     * Main entry point for application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        OptionalExercise03 exercises = new OptionalExercise03();
        exercises.runExercises();
        System.out.println("Program ends");
    }
}

