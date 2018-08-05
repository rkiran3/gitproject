package com.sandbox.java8;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.lang.Math.*;
/**
 * A Function<T, R> operates on something and returns something:
 * it takes one argument (of generic type T) and
 * returns an object (of generic type R).
 * You can call apply() method on a Function object.
 */
public class FunctionExercise01 {
    public static void main(String [] args) {

        String numbers = "4, -9, 16";
        Stream<Integer> integerStream = Arrays
                .stream(numbers.split(", "))
                .map(Integer::parseInt);
        integerStream
                .map(i -> (i<0) ? -i : i)
                .forEach(System.out::println);

        Function<Integer, String> intToString = Object::toString;
        Function<String, Integer> parseInt = Integer::parseInt;
        Function <Integer, Integer> absInt = java.lang.Math::abs;
        // this can be replaced by IntFunction which works with Primitives
        Function<String, Integer> parseIntPrimitive = Integer::parseInt;
        IntFunction absIntPrimitive = Math::abs;
        Function<String, Integer> parseAndAbsInt = parseInt.andThen(absInt);
        //IntFunction<String, int> parseAndAbsInt2 = parseIntPrimitive.andThen(absIntPrimitive);

        Arrays
                .stream("4, -9, 16".split(", "))
                .map(parseAndAbsInt)
                .forEach(System.out::println);

        // convert all entities to absolute value and then convert to String to print
        String output = Arrays.stream("4, -9, 16".split(", "))
        	.map(parseAndAbsInt)	// parse each entity and convert to absolute value
        	.map(String::valueOf)	// convert each entity to String value
        	.collect(Collectors.joining(", "));	// create a long String with separators
        
        System.out.println(output);	// Output: 4, 9, 16
    }
}
