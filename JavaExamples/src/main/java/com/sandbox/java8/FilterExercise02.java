package com.sandbox.java8;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;

public class FilterExercise02 {
    public static void main(String []args) {
        char givenChar = 's';
        String state = "mississippi";

        long count = state.chars()
                .filter(i -> i == givenChar)
                .count();

        System.out.println(String.format("Found %d occurrences of %c in %s ",
                count, givenChar, state));
    }
}
