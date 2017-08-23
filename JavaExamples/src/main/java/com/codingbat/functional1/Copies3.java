package com.codingbat.functional1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 */
public class Copies3 {
    public static List <String> copies3(List<String> strings) {

        List <String> output = strings.stream()
                .map(w -> String.join("", Collections.nCopies(3, w)))
                .collect(Collectors.toList());

        return output;
    }
    public static void main(String [] args) {

        String [] inputStrings = {"hello", "topeka"};

        List <String> outputStrings = copies3(Arrays.asList(inputStrings));
        outputStrings.stream()
                .forEach(System.out::println);

    }
}
