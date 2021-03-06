package com.codingbat.functional1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class Copies3 {
    // make copies of the list
    public static List <String> copies3(List<String> strings) {

        List <String> output = strings.stream()
                .map(word -> String.join("", Collections.nCopies(3, word)))
                .collect(Collectors.toList());

        return output;
    }
    public static void main(String [] args) {

        String [] inputStrings = {"hello", "topeka"};
        // Input: { hello, topeka }
        // Output: returns a list of String each string made a copy if itself.
        // hello,hello,hello
        // topeka,topeka, topeka
        List <String> outputStrings = copies3(Arrays.asList(inputStrings));
        outputStrings.stream()
                .forEach(System.out::println);
    }
}
