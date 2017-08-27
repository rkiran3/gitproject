package com.codingbat.functional2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *Given a list of strings, return a list of the strings, omitting any string that contains a "z". (Note: the str.contains(x) method returns a boolean)

 noZ(["aaa", "bbb", "aza"]) → ["aaa", "bbb"]
 noZ(["hziz", "hzello", "hi"]) → ["hi"]
 noZ(["hello", "howz", "are", "youz"]) → ["hello", "are"]
 */
public class NoZ {
    public static List <String> noZ (List <String> strings) {
        return strings.stream()
                .filter(s -> !s.contains("z"))
                .collect(Collectors.toList());
    }
    public static void main(String []args) {
        System.out.println("Test1");
        noZ(Arrays.asList("aaa", "bbb", "aza")).stream()
                .forEach(System.out::println);

        System.out.println("Test2");
        noZ(Arrays.asList("hziz", "hzello", "hi")).stream()
                .forEach(System.out::println);
        System.out.println(noZ(Arrays.asList("hziz", "hzello", "hi"))
                .equals(Arrays.asList("hi")));

        System.out.println("Test3");
        noZ(Arrays.asList("hello", "howz", "are", "youz")).stream()
                .forEach(System.out::println);
        System.out.println(
                noZ(Arrays.asList("hello", "howz", "are", "youz"))
                        .equals(Arrays.asList("hello", "are")));

    }
}
