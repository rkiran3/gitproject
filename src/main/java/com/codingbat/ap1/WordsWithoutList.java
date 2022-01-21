package com.codingbat.ap1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array of strings, return a new List (e.g. an ArrayList) where all the strings of the given length are omitted. See wordsWithout() below which is more difficult because it uses arrays.

 wordsWithoutList(["a", "bb", "b", "ccc"], 1) → ["bb", "ccc"]
 wordsWithoutList(["a", "bb", "b", "ccc"], 3) → ["a", "bb", "b"]
 wordsWithoutList(["a", "bb", "b", "ccc"], 4) → ["a", "bb", "b", "ccc"]
 */
public class WordsWithoutList {
    public static List <String> wordsWithoutList(String [] words, int len) {
        return (Arrays.asList(words)).stream()
                .filter(s -> (s.length() != len))
                .collect(Collectors.toList());
    }

    public static void main(String [] args) {
        String [] words = {"a", "bb", "b", "ccc"};
        assert(wordsWithoutList(words, 1)
            .equals(Arrays.asList("bb", "ccc")));
    }
}
