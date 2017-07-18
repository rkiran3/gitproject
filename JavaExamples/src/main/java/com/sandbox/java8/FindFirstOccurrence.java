package com.sandbox.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 */
public class FindFirstOccurrence {
    public static void main(String [] args) {
        //IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        int [] numbersArray = { 21, 32, 34, 74, 58};
        IntStream.range(0, numbersArray.length)
                .collect(HashMap::new,
                        (hashMap, val) -> hashMap.put(hashMap.size(), numbersArray[val]),
                        (hashMap, val) -> {})
                .forEach((index, val) -> System.out.printf("%d => %d\n", index, val));

        Stream<String> s = Stream.of("apple", "banana", "orange");
        Map<Character, String> m = s.collect(
                Collectors.toMap(s1 -> s1.charAt(0),
                        s1 -> s1));

        Arrays.asList(numbersArray).stream();
                //.stream()
        //IntStream.range(0, numbersArray.length).asLongStream()
        //        .collect(
        //                Collectors.toMap(Function.identity(), v-> v));
    }
}
