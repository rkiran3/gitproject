package com.sandbox.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GetDigits {

    public static void main(String[] args) {

        String[] nums = { "AC23BD46", "SH74", "CD96" };

        String output = Arrays.asList(nums).stream()
            .flatMap(w ->
                Pattern.compile("\\p{Digit}")
                    .matcher(w)
                    .results()
                    .map(mo -> mo.group())
                )
            .collect(Collectors.joining()); // prints 23467496

            System.out.println(output);
    }
}
