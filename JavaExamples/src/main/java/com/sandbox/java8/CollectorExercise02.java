package com.sandbox.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Found on Stackoverflow, Print a list of elements grouped by a user specified partition
 *
 * Input:
 *  "a", "b", "c", "d", "e"    // Separate them by 3
 * Output:
 * a,b,c
 * d,e
 */
public class CollectorExercise02 {
    public static void main(String[] args) {
        final Collection<String> list = Arrays.asList("a", "b", "c", "d", "e");
        final int size = 3;
        final AtomicInteger idx = new AtomicInteger(0);
        final Collection<List<String>> rows = list.stream()
                .collect(
                        Collectors.groupingBy(
                                it -> idx.getAndIncrement()/size))
                .values();

        final String result = rows.stream()
                .map(row ->String.join(",", row))
                .collect(Collectors.joining("\n"));

        System.out.println(result);
    }
}
