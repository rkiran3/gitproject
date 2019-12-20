package com.sandbox.java8;

import java.util.stream.IntStream;

/**
 *
 */
public class StreamPeekExercise01 {

    public static void main(String [] args) {
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        System.out.println("Number of Elements: " + intStream.count());


    }
}
