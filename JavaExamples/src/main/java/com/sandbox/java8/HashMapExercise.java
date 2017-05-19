package com.sandbox.java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
class Buyer {
    String name;
    int age;

    public int getAge() {        return age;    }

    public void setAge(int age) {        this.age = age;    }
    public String getName() {        return name;    }

    public void setName(String name) {        this.name = name;    }

    public Buyer(String name, int age) {        this.name = name;        this.age = age;    }
}

public class HashMapExercise {
    private static Map<String, Buyer> buyerMap = new HashMap<>();

    /**
     * Returns a list of Names
     * @return
     */
    private static List<Object []> splitNames() {

        // returns a list of objects - each object consists of an array of two
        // elements (first name) - (last name).
        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        return splitUpNames;
    }

    /**
     * Create a simple hashMap to store objects and print them.
     */
    private static Map<String, Integer> simpleHashMap() {
        Map<String, Integer> testMap = new HashMap();
        testMap.put("January", 31);
        testMap.put("February", 28);

        testMap
                .entrySet()
                .forEach(entry -> System.out.printf("%s:%d\n", entry.getKey(), entry.getValue())
                );

        return testMap;
    }

    public static void main(String [] args) {
        HashMapExercise.simpleHashMap();
        HashMapExercise.splitNames();
    }
}
