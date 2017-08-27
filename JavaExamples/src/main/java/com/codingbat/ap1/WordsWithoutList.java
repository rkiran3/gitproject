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

        List<String> wordsList = (Arrays.asList(words)).stream()
                .filter(s -> (s.length() != len))
                .collect(Collectors.toList());

        //String [] frontWords = wordsList.toArray(new String[wordsList.size()]);

        return wordsList;
    }

    public static void main(String [] args) {
        String [] words = {"a", "bb", "b", "ccc"};
        if (wordsWithoutList(words, 1)
            .equals(Arrays.asList("bb", "ccc"))) {
            System.out.println("Test1 passes");
        } else {
            System.out.println("Test1 fails");
        }
    }
}
