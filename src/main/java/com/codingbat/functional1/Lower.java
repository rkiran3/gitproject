package com.codingbat.functional1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of strings, return a list where each string is 
 * converted to lower case (Note: String toLowerCase() method).
 */
public class Lower {
    public static List <String> lower(List<String> strings) {
        List <String> output = strings.stream()
                .map(w -> w.toLowerCase())
                .collect(Collectors.toList());
        return output;
    }
    public static void main(String [] args){
        String [] words = { "Hello", "Hi"};
        List <String> wordsList = Arrays.asList(words);
        List <String> outputList = lower(wordsList);
    
        // Construct an expectedList to compare with modified List
        List <String> expectedList = Arrays.asList(new String[] {"hello", "hi"});
        outputList.stream()
                .forEach(System.out::println);
                
        assert(outputList.equals(expectedList));
    }
}
