package com.codingbat.functional1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
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

        outputList.stream()
                .forEach(System.out::println);
    }
}
