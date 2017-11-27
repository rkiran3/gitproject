package com.codingbat.functional1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of strings, return a list where each string has all its "x" removed.

 noX(["ax", "bb", "cx"]) → ["a", "bb", "c"]
 noX(["xxax", "xbxbx", "xxcx"]) → ["a", "bb", "c"]
 noX(["x"]) → [""]
 https://stackoverflow.com/questions/40962922/java-8-int-stream-collect-with-stringbuilder
 */
public class NoX {

    public static void main(String [] args) {
        List<String> wordsList = Arrays.asList("ax", "bb", "cx");

        wordsList.stream()
                .map(w -> w.chars()
                .filter(c -> c != 'x')
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append))
                .forEach(System.out::println);
    }
}
