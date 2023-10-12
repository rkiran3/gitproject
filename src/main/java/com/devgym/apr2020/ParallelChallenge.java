package com.devgym.apr2020;

import java.util.ArrayList;
import java.util.List;

public class ParallelChallenge {
    public static void main(String... doYourBest) {

        List<Simpson> simpsons = new ArrayList<Simpson>();
        simpsons.add(new Simpson(10));
        simpsons.add(new Simpson(15));
        simpsons.add(new Simpson(11));
        simpsons.add(new Simpson(20));
        simpsons.add(new Simpson(22));

        simpsons.stream().parallel()
                .filter(s -> s.age > 10)
                .map(s -> s + ",")
                .forEachOrdered(System.out::print);

        System.out.println();

        simpsons.stream().parallel()
                .filter(s -> s.age > 10)
                .map(s -> s + ",")
                .forEach(System.out::print);
    }

    static class Simpson {
        int age;

        public Simpson(int age) {
            this.age = age;
        }

        public String toString() {
            return "" + this.age;
        }
    }
}
/*
 * What will happen after the main method is executed as follows?
 * 
 * javac ParallelChallenge.java
 * java ParallelChallenge
 * 
 * Choices - Select all that apply.
 * Choice 1
 * 
 * 11,15,20,22,
 * 11,20,15,22,
 * 
 * Choice 2
 * 
 * 11,15,20,22,
 * 15,11,20,22,
 * 
 * Choice 3
 * 
 * 11,15,20,22,
 * Random values in the second Stream will be printed
 * 
 * Choice 4
 * 
 * 15,11,20,22,
 * Random values in the second Stream will be printed
 * 
 * 
 */
