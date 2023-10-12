package com.codingbat.ap1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array of strings, return a new array containing the first N strings. N will be in the range 1..length.

 wordsFront(["a", "b", "c", "d"], 1) → ["a"]
 wordsFront(["a", "b", "c", "d"], 2) → ["a", "b"]
 wordsFront(["a", "b", "c", "d"], 3) → ["a", "b", "c"]
 */
public class WordsFront {
    public static String [] wordsFront(String [] words, int n) {

        List<String> wordsList = (Arrays.asList(words)).stream()
                .limit(n)
                .collect(Collectors.toList());

        String [] frontWords = wordsList.toArray(new String[wordsList.size()]);

        return frontWords;
    }

    public static void main(String [] args) {
        String [] words = {"a", "b", "c", "d"};
        Arrays.asList(wordsFront(words, 2)).stream()
                .forEach(System.out::println);
    }
}
