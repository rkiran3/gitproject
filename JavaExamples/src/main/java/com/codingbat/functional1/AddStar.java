package com.codingbat.functional1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Add a star at end of each word
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
        // input: "hello", "world"        output: "hello*",  "world*"
        List <String> outputStrings = addStar(names);

        List <String> expectedList = Arrays.asList(new String[] { "hello*", "world*" });        
        assert(outputStrings.equals(expectedList));
        
        String finalString = outputStrings.stream()
            .collect(Collectors.joining(", "));
        assert(finalString.equals("hello*, world*"));
            
    }
}
