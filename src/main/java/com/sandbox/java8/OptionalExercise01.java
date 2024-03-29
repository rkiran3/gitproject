package com.sandbox.java8;

import static org.junit.Assert.assertEquals;

/**
 * OptionalExercise01
 */
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
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
        String result = Optional.ofNullable(status) // if status is null, then return empty string
                .orElse("");

        if (!result.equals("")) {
            System.out.println("Exercise01: Test 1 Fails");
        }

        // test2: check for existing string
        status = "success";
        result = Optional.ofNullable(status) // if status is not null, then return status string
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

        // check for null BigDecimal
        BigDecimal bigNum = null;
        // if null, then set it to default ZERO
        String val = Optional.ofNullable(bigNum)
                .orElse(BigDecimal.ZERO)
                .toString(); // return string representation
        assertEquals("0", val);

        // check for BigDecimal value 1
        BigDecimal bigNumOne = BigDecimal.ONE;
        // if null, then set it to default TEN
        val = Optional.ofNullable(bigNumOne)
                .orElse(BigDecimal.TEN)
                .toString(); // return string representation
        assertEquals("1", val);
    }

    private void exercise2() {
        // Inner class for testing List
        class Cover {
            private List<String> coverList;

            public void setCoverList(List<String> coverList) {
                this.coverList = coverList;
            }
            
            public List<String> getCoverList() {
                return this.coverList;
            }
        }

        Cover cover = new Cover();
        List<String> namesList = Stream.of("January", "February")
                .collect(Collectors.toList());

        // namesList.forEach(System.out::println);
        cover.setCoverList(namesList);
        cover.setCoverList(null);
        if (cover.getCoverList() == null) {
            System.out.println("coverlist is empty");
        }
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
