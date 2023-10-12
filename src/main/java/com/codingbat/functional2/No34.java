package com.codingbat.functional2;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Given a list of strings, return a list of the strings, omitting any string length 3 or 4.

 no34(["a", "bb", "ccc"]) → ["a", "bb"]
 no34(["a", "bb", "ccc", "dddd"]) → ["a", "bb"]
 no34(["ccc", "dddd", "apple"]) → ["apple"]
 */
public class No34 {

    // Takes input an String array and returns filtered array of elements
    // whose values are not length 3 or 4
    public static String[] filterInput(String[] input) {
        // Define a Predicate that takes in a String and returns boolean
        // if its length is not 3 or 4
        Predicate<String> checkLength = w -> !(w.length() == 3 || w.length() == 4);

        // Use Predicate in Streams and construct a new String Array
        String[] output = Arrays.asList(input)
            .stream()
            .filter(checkLength)
            .toArray(String[]::new);

        return output;
    }

    public static void main(String [] args) {

        String[] input = {"a", "bb", "ccc"};
        String[] expected = {"a", "bb"};
        String[] output = filterInput(input);
        boolean result = Arrays.asList(output).equals(Arrays.asList(expected));
        System.out.println(result ? "Test Pass" : "Test Fails");

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
