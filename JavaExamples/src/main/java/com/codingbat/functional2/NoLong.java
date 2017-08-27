package com.codingbat.functional2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of strings, return a list of the strings, omitting any string length 4 or more.

 noLong(["this", "not", "too", "long"]) → ["not", "too"]
 noLong(["a", "bbb", "cccc"]) → ["a", "bbb"]
 noLong(["cccc", "cccc", "cccc"]) → []
 */
public class NoLong {
    public static List<String> noLong(List <String> strings) {

        return strings.stream()
                .filter(s -> s.length() < 4)
                .collect(Collectors.toList());
    }

    public static void main(String []args) {
        noLong(Arrays.asList("this", "not", "too", "long")).stream()
                .forEach(System.out::println);
    }
}
