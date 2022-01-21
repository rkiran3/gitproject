package com.codingbat.functional2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of strings, return a list of the strings, omitting any string length 3 or 4.

 no34(["a", "bb", "ccc"]) → ["a", "bb"]
 no34(["a", "bb", "ccc", "dddd"]) → ["a", "bb"]
 no34(["ccc", "dddd", "apple"]) → ["apple"]
 */
public class No34 {
    public static void main(String [] args) {
        if ((Arrays.asList("a", "bb", "ccc")).stream()
                .filter(w -> !(w.length() == 3 || w.length() == 4))
                .collect(Collectors.toList())
                .equals(Arrays.asList("a", "bb"))) {
            System.out.println("Test1 Pass");
        } else {
            System.out.println("Test1 Fails");
        }

        if ((Arrays.asList("a", "bb", "ccc", "dddd")).stream()
                .filter(w -> !(w.length() == 3 || w.length() == 4))
                .collect(Collectors.toList())
                .equals(Arrays.asList("a", "bb"))) {
            System.out.println("Test2 Pass");
        } else {
            System.out.println("Test2 Fails");
        }

        if ((Arrays.asList("ccc", "dddd", "apple")).stream()
                .filter(w -> !(w.length() == 3 || w.length() == 4))
                .collect(Collectors.toList())
                .equals(Arrays.asList("apple"))) {
            System.out.println("Test3 Pass");
        } else {
            System.out.println("Test3 Fails");
        }

    }
}
