package com.devgym.apr2020;

public class GenericsChallenge2 {
	public static void main(String ...doYourBest) {
        // Archer archer = new Archer();

        // archer.attack("->");
        // archer.attack(Double.valueOf(1.0));
        // archer.attack(Float.valueOf(1));
    }

    static class Archer<T> {
        T t;

        void attack(T t) {
            System.out.println(this.t);
        }
    }

}

/*
 What will happen after the main method is executed as follows?

javac GenericsChallenge2.java
java GenericsChallenge2

Choices - Select all that apply.
Choice 1
->

followed by ClassCastException


Choice 2
->​​​​​​​​​​​​​​​​​​​​​
1.0
1.0

Choice 3
->
followed by IllegalArgumentException

Choice 4 <--- Correct answer
null
null
null
 
 */
