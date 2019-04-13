package com.codingbat.ap1;

import java.util.Arrays;
import java.util.stream.Stream;

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

        //Predicate<String> getWordsOfLen = (l) -> l.length()
   	    //Predicate<String> getWordsOfLen(final int len) = { w -> w.length() == len ;}
            
        long count = Stream.of(words)
                .filter(w -> w.length() == 1)
                .count();
        if (count != 2) {
        	System.out.println("Test fails");
        }
        
        words = new String [] {"a", "bb", "b", "ccc"};
        System.out.println(wordsCount(words, 3));
    }

}
