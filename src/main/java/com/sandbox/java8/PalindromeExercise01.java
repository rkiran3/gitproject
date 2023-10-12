package com.sandbox.java8;

import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class PalindromeExercise01 {

    public static void main(String [] args) {
        List<String> list = Arrays.asList("abc", "def", "zzb", "cba", "yes", "fred", "fed");

        list.stream()
                .peek(System.out::println)
                .collect(Collectors.groupingBy(s -> {
                    char[] array = s.toCharArray();
                    Arrays.sort(array);
                    return CharBuffer.wrap(array);
                }))
                .values().stream()
                //.filter(group -> group.size() > 1)
                .forEach(System.out::println);
    }
}
