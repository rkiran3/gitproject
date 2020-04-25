package com.devgym.apr2020;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalInterfaceChallenge {
	static Function <Integer, Integer> mult = a -> a * a;
	
    static BiFunction<Integer, Integer, Integer> heisenberg =
            (a, b) -> a + b;

    static Function<Integer, Integer> jesse = a -> a - 2;

    static BiFunction<Integer, Integer, Integer> saul =
            heisenberg.andThen(jesse);

    static BiConsumer<Integer, Integer> gustavo =
            (a, b) -> System.out.println(a + 2 / b + 2);

    public static void main(String[] breakingBad) {
    	System.out.println( 2 + 0 / 2 + 2);
    	
    	System.out.println(mult.apply(44));
    	System.out.println(jesse.apply(44));
        Integer firstLaunder = saul.apply(2, 2);

        heisenberg.andThen(jesse);
        Integer secondLaunder = heisenberg.apply(2, 2);

        gustavo.accept(firstLaunder, secondLaunder);
    }

}

/*
What will happen after the main method is executed as follows?

javac FunctionalInterfaceChallenge.java
java FunctionalInterfaceChallenge

Choices - Select all that apply.
Choice 1

-2

Choice 2

6

Choice 3

4

Choice 4

java.lang.ArithmeticException: / by zero

*/
