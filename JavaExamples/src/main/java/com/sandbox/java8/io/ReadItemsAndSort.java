package com.sandbox.java8.io;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 */
public class ReadItemsAndSort {
    public static void main(String []args) {
        List<String> lines = null;
        try {
            // Read a file containing Item Numbers
            lines = Files.lines(Paths.get("c://Downloads/ItemNumbers.csv"))
                    .collect(Collectors.toList());

            // Sort the Item Numbers ["A-Item", "B-Item", "C-Item"]
            lines.stream()
                    .sorted()
                            //.forEach(System.out::println);
                    .count();

            // Group items by their count to find duplicate items.
            Map<String, Long> groupedItems = lines.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
