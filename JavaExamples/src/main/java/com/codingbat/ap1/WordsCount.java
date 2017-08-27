package com.codingbat.ap1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class WordsCount {
    public static int wordsCount(String [] words, int len) {

        int wordCount = (int)(Arrays.asList(words)).stream()
                .filter(w -> w.length() == len)
                .count();
        return wordCount;
    }

    public static void main(String [] args) {
        String [] words = {"a", "bb", "b", "ccc"};
        System.out.println(wordsCount(words, 1));

        words = new String [] {"a", "bb", "b", "ccc"};
        System.out.println(wordsCount(words, 3));
    }

}
