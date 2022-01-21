package com.devgym.apr2020;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GenericsChallenge3 {
	public static void main(String... doYourBest) {
        List<String> firstResult =  GenericsChallenge3.<String>get(new ArrayList<>(), new String("1")); // Line 9

        List<Object> secondResult = GenericsChallenge3.get("Homer", Double.valueOf("4"));

        Stream<Object> stream = Stream.concat(
            firstResult.stream(), secondResult.stream());
            
        stream.forEach(System.out::println);
    }

    public static <T> List<T> get(List<T> list, T t) {
        list.add(t);
        return list;
    }

    public static <T, R extends T> List<T> get(T type1, R type2) {
        List<T> list = new ArrayList<>();
        list.add(type1);
        list.add(type2); // Line 27
        return list;
    }
}
/*
What will happen after the main method is executed as follows?

javac GenericsChallenge3.java
java GenericsChallenge3

Choices - Select all that apply.
Choice 1
There will be a ClassCastException in the line 27

Choice 2 <-- Correct answer
1
Homer
4.0

Choice 3
It won't compile at line 9.
*/