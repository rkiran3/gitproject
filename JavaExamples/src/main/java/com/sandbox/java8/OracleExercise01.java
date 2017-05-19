package com.sandbox.java8;

/**
 *
 */

/**
 * Copyright © 2016, Oracle and/or its affiliates. All rights reserved.
 *
 * JDK 8 MOOC Lesson 2 homework
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SonnetFile {
    public static String sonnetData = "From fairest creatures we desire increase,\n" +
            "That thereby beauty's rose might never die,\n" +
            "But as the riper should by time decease,\n" +
            "His tender heir might bear his memory:\n" +
            "But thou contracted to thine own bright eyes,\n" +
            "Feed'st thy light's flame with self-substantial fuel,\n" +
            "Making a famine where abundance lies,\n" +
            "Thy self thy foe, to thy sweet self too cruel:\n" +
            "Thou that art now the world's fresh ornament,\n" +
            "And only herald to the gaudy spring,\n" +
            "Within thine own bud buriest thy content,\n" +
            "And, tender churl, mak'st waste in niggarding:\n" +
            "Pity the world, or else this glutton be,\n" +
            "To eat the world's due, by the grave and thee.\n";
}

/**
 * @author Speakjava (Simon Ritter)
 */
public class OracleExercise01 {
    private static final String WORD_REGEXP = "[- .:,]+";
    private static final String dataFile = "C:\\Projects-Git\\gitproject\\JavaExamples\\src\\SonnetI.txt";
    /**
     * Run the exercises to ensure we got the right answers
     *
     * @throws java.io.IOException
     */
    public void runExercises() throws IOException {
        System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 2");
        System.out.println("Running exercise 1 solution...");
        exercise1();
        System.out.println("Running exercise 2 solution...");
        exercise2();
        System.out.println("Running exercise 3 solution...");
        exercise3();
        System.out.println("Running exercise 4 solution...");
        exercise4();
        System.out.println("Running exercise 4 Sonnet solution...");
        exercise4SonnetFile();
        System.out.println("Running exercise 5 solution...");
        exercise5();
        System.out.println("Running exercise 6 solution...");
        exercise6();
        System.out.println("Running exercise 7 solution...");
        exercise7();
    }

    /**
     * Exercise 1
     *
     * Create a new list with all the strings from original list converted to
     * lower case and print them out.
     */
    private void exercise1() {
        List<String> list = Arrays.asList(
                "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

        list.stream()
                .map(word -> word.toLowerCase())
                .forEach(System.out::println);
    }

    /**
     * Exercise 2
     *
     * Modify exercise 1 so that the new list only contains strings that have an
     * odd length
     */
    private void exercise2() {
        List<String> list = Arrays.asList(
                "The", "Quick", "BROWN", "Fox", "Jumped", "Over", "The", "LAZY", "DOG");

        list
            .stream()
            .filter(n -> n.length() % 2 != 0)
            .forEach(System.out::println);
    }

    /**
     * Exercise 3
     *
     * Join the second, third and forth strings of the list into a single string,
     * where each word is separated by a hyphen (-). Print the resulting string.
     */
    private void exercise3() {
        List<String> list = Arrays.asList(
                "The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "dog");

        System.out.println(list.subList(1, 4).stream()
                .collect(Collectors.joining("-")));
    }

    /**
     * Count the number of lines in the file using the BufferedReader provided
     */
    private void exercise4() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get(dataFile), StandardCharsets.UTF_8)) {
            long lineCount = reader.lines().count();
            System.out.println("Line Count: " + lineCount);
        }
    }

    /**
     * Count the number of lines in the file using the BufferedReader provided
     */
    private void exercise4SonnetFile() throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new StringReader((SonnetFile.sonnetData)));
            long lineCount = reader.lines().count();
            System.out.println("Line Count: "+lineCount);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Using the BufferedReader to access the file, create a list of words with
     * no duplicates contained in the file.  Print the words.
     *
     * HINT: A regular expression, WORD_REGEXP, is already defined for your use.
     */
    private void exercise5() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get(dataFile), StandardCharsets.UTF_8)) {

        List <String> wordsList = reader
                    .lines()
                    .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
                    .distinct()
                    .collect(Collectors.toList());

            System.out.println("Total unique words: " + wordsList.size());
        }
    }

    /**
     * Using the BufferedReader to access the file create a list of words from
     * the file, converted to lower-case and with duplicates removed, which is
     * sorted by natural order.  Print the contents of the list.
     */
    private void exercise6() throws IOException {

        try (
                BufferedReader reader = Files.newBufferedReader(
                Paths.get(dataFile), StandardCharsets.UTF_8)) {
                reader
                    .lines()
                    .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
                    .distinct()
                    .sorted()
                    .map(w -> w.toUpperCase())
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
        }
    }

    /**
     * Modify exercise6 so that the words are sorted by length
     */
    private void exercise7() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get(dataFile), StandardCharsets.UTF_8)) {
      /* YOUR CODE HERE */
        }
    }

    /**
     * Main entry point for application
     *
     * @param args the command line arguments
     * @throws IOException If file access does not work
     */
    public static void main(String[] args) throws IOException {
        OracleExercise01 lesson = new OracleExercise01();
        lesson.runExercises();
    }
}

