package com.sandbox.java8;

import java.time.LocalDate;
import java.util.stream.Stream;

/**
 *
 */
public class DateTimeExercise01 {

    public static void getNumberOfFutureDays() {
        
    }

    public static void main(String [] args) {
        // Print consecutive days from today
        Stream.iterate(LocalDate.now(), ld -> ld.plusDays(1L))
                .limit(10)
                .forEach(System.out::println);

    } // main ends
}
