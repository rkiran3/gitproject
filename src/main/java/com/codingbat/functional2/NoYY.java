package com.codingbat.functional2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of strings, return a list where
 * each string has "y" added at its end,
 * omitting any resulting strings that contain "yy" as a substring anywhere.

 noYY(["a", "b", "c"]) → ["ay", "by", "cy"]
 noYY(["a", "b", "cy"]) → ["ay", "by"]
 noYY(["xx", "ya", "zz"]) → ["xxy", "yay", "zzy"]
 */
public class NoYY {
    public static List <String> noYY(List<String> strings) {
        return strings.stream()
                .map(s -> s+"y")
                .filter(s -> !s.contains("yy"))
                //.peek(s -> System.out.printf("peeking: %s\n", s))
                .collect(Collectors.toList());
    }

    public static void main(String []args) {

        if (noYY(Arrays.asList("a", "b", "c"))
                .equals(Arrays.asList("ay", "by", "cy"))){
            System.out.println("Test1 pass");
        } else {
            System.out.println("Test1 fails");
        }

        if (noYY(Arrays.asList("a", "b", "cy"))
                .equals(Arrays.asList("ay", "by"))){
            System.out.println("Test2 pass");
        } else {
            System.out.println("Test2 fails");
        }
    }
}
