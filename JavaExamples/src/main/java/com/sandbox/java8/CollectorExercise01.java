package com.sandbox.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import static java.util.stream.Collectors.*;  // Notice the static import
/**
 *
 */

public class CollectorExercise01 {

    // Define a Predicate that will check if a number is greater than specific number
    public static Predicate<Integer> greaterThanN(final int max) {
        return number -> number > max;
    }

    /**
     * Prints the elements in list that are greater than the argument passed to it.
     */
    public static void printListGreaterThan(List<Integer> intList, int max) {
        intList
                .stream()
                .filter(greaterThanN(max))
                .forEach(System.out::println);

        return;
    }



    public static void main(String[] args) {
        Integer [] intArray = { 10, 20, 30};
        List <Integer> intList = new ArrayList<>(Arrays.asList(intArray));

        List <Integer> listGreaterThan10 = intList
                .stream()
                .filter(iA -> iA > 10)
                .collect(toList());

        System.out.println("Size of listGreaterThan10 " + listGreaterThan10.size());

        printListGreaterThan(intList, 5);
    }
}
