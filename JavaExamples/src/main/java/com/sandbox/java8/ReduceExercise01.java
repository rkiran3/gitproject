package com.sandbox.java8;

import java.util.stream.Stream;

/**
 *
 */
public class ReduceExercise01 {
    public static void main(String [] args) {
        // The stream of words are converted to their lengths
        // and then the sum of their total length is returned.
        int total = Stream.of("One", "Two", "Three")
                .mapToInt(word -> word.length())
                .reduce (0, (len1, len2) -> len1+len2);

        // total of all words.
        assert(11 == total);

    }
}
