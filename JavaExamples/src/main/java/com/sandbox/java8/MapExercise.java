package com.sandbox.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//import static java.util.stream.Collectors.*;

/**
 *
 */

interface Converter <F, T> {

    T convert(F from) ;
}
public class MapExercise {

    /**
     * map() returns a stream of values
     * @return a List of updated prices
     */
    public static List <Double> increasePrice(List <Integer> prices, int percentage) {
        List <Double> increasedPrices;
        double percentageDbl = percentage/100.0;

        /*prices
                .stream()
                .map(cost -> (cost*percentage/100) + cost)
                .forEach(System.out::println);*/

        increasedPrices = prices
                .stream()
                .map(cost -> (cost*percentageDbl) + cost)
                .collect(Collectors.toList());

        return increasedPrices;
    }
    public static void main(String [] args) {
        Converter <String, Integer> converter = (from) -> Integer.valueOf(from);

        Integer converted = converter.convert("20");
        System.out.println("converted = " + converted);

        List <Integer> prices = Arrays.asList(100, 200, 300);
        int percentage = 10;
        List <Double> increasedPrices = increasePrice(prices, percentage);

        prices.stream()
                .map((cost)  -> (cost*0.12)+cost)
                .forEach(System.out::println);

        // Declare a function that returns a boolean
        Predicate<Integer> isGreaterThan100 = (number) -> number > 200;

        // Declare a function that returns a boolean
        Function<Integer, Predicate<Integer>> isGreaterThanN =
                (Integer pivot) -> (Integer number) -> number > pivot;

        System.out.println("Printing all numbers Greater than 100");
        prices
            .stream()
            .filter(isGreaterThanN.apply(200))
            .forEach(System.out::println);

        // Get binary representation of a number
        String binString = Integer.toBinaryString(15);  // returns a String "1111"

        // convert to Stream of Characters
        Stream<Character> charStream = binString
                .chars()
                .mapToObj(i -> (char)i);

        // Print if each character is value 1
        charStream.forEach(i-> System.out.println("Testing if char is 1: " + (((char)i & 1)==1)));
        System.out.println("");

        // Produces IntStream
        System.out.println("Printing IntStream (i.e. int-valued elements ");
        binString.chars()
                .forEach (ch -> System.out.printf("%c ", ch) );
        System.out.println("");

        System.out.println("Printing Character Stream consisting of java.lang.Character elements");
        binString
                .chars()
                .mapToObj(ch -> (char)ch)
                .forEach (ch -> System.out.printf("%c %s\n", ch, ch.getClass().getName()));

        // Print total number of 1s in a binary string
        System.out.println(binString.chars()
                .filter(i -> (i&1)==1).count());

        System.out.println("Printing Integer List: ");
        List <Integer> integerList = null;
        IntStream
                .range(1, 10)
                .mapToObj(i -> Integer.toBinaryString(i))
                .flatMap(w -> w.chars().mapToObj(i -> (char) i))
                .forEach(ch -> System.out.printf("%s ", ch));

        // Get a Map of frequencies of 1 and 0's for all integers between 1..10
        // Function.identity() Returns a function that always returns its input argument.
        Map<Character, Long> frequencies = IntStream
                .range(1, 10)
                .mapToObj(i -> Integer.toBinaryString(i))
                .flatMap(w -> w.chars().mapToObj(i-> (char)i))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Printing Frequency of occurrence");
        frequencies
                .forEach((key, value) -> System.out.printf("%c %d \n", key, value));

        /*"hello".chars()
                .mapToObj(i -> (char)i)
                .forEach(ch -> System.out.printf("%c %s \n", ch, ch.getClass()));*/
                //.forEach(System.out::println);

        int [] intprices = prices.stream().mapToInt(Integer::intValue).toArray();

        System.out.println("intprices = " + intprices);

        Stream.of("January", "February", "March", "April", "May", "June", "July", "August")
                .peek(System.out::println)
                .forEach(System.out::println);
                //.filter(month -> month.endsWith("y"))
                //.peek(System.out::println)
                //.limit(2);
    }
}
