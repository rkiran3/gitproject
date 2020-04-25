package com.devgym.apr2020;

import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FunctionChallenge {
	public static void main(String ... doYourBest) {
        String starWars = "Luke DarthVader ObiWan QuiGonJinn Palpatine";
        
        Function<String, Stream<String>> lineSplitter =
                l -> Pattern.compile(" ").splitAsStream(l); // Line 11
                
        Stream.of(starWars)
                .flatMap(lineSplitter)
                .sorted(((o1, o2) -> o2.compareTo(o1)))
                .forEachOrdered(System.out::println);
    }
}
/*
What will happen after the main method is executed as follows?
javac FunctionChallenge.java
java FunctionChallenge
Choices - Select all that apply.
Choice 1
DarthVader Luke ObiWan Palpatine QuiGonJinn
Choice 2
NoSuchElementException will be thrown at the line 11 
Choice 3 <-- Correct Answer
QuiGonJinn Palpatine ObiWan Luke DarthVader
}
*/