package com.codingbat.functional1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class AddStar {
    public static List <String> addStar(List<String> strings) {
        List <String> outputStrings = strings.stream()
                .map(s -> s + "*")
                .collect(Collectors.toList());
        return outputStrings;
    }

    public static void main(String []args) {
        String [] namesArray = { "hello", "world" };
        List <String> names = Arrays.asList(namesArray);

        List <String> outputStrings = addStar(names);
        outputStrings.stream()
                .forEach(System.out::println);
    }
}
